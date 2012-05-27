package org.unidal.wdbc.dianping;

import java.util.Map;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.infotree.InfoTreeConnector;
import org.unidal.wdbc.infotree.InfoTreeMessage;

public class Processor implements org.unidal.wdbc.http.Processor, Initializable {
   private Configuration m_configuration;

   private InfoTreeConnector m_connector;

   private String action;

   private String username;

   private String password;

   private String category;

   private String province;

   private String city;

   private boolean DEBUG = true;

   public void initialize() throws InitializationException {
      username = m_configuration.getUserName();
      password = m_configuration.getPassword();
      action = m_configuration.getAction();
      city = m_configuration.getCityName();
      province = m_configuration.getProvinceName();
      category = m_configuration.getCategoryInfoTree();
   }

   public void execute(Session session) {
      Map<String, String> prop = session.getProperties();
      String type = prop.get("list:type");
      String title = prop.get("details:title");
      String districtName = prop.get("details:district");
      String body = prop.get("details:body");
      String mobilephone = prop.get("details:mobilephone");
      String telephone = prop.get("details:telephone");
      String qq = prop.get("details:qq");
      String msn = prop.get("details:msn");
      String email = prop.get("details:email");
      String contactInfo = prop.get("details:contact");
      String picture = prop.get("details:picture");

      if (districtName == null || districtName.length() == 0) {
         districtName = "�Ϻ�";
      }

      if (type != null && type.equals("��Ƹ")) {
         type = "1"; // iwant
      } else if (body != null && type.equals("��ְ")) {
         type = "2"; // ihave
      } else {
         type = "3"; // unknown
      }

      InfoTreeMessage msg = new InfoTreeMessage();

      msg.setUsername(username);
      msg.setPassword(password);
      msg.setTitle(title);
      msg.setContent(body + "\r\n\r\n" + contactInfo);
      msg.setType(type);
      msg.setCategory(category);
      msg.setProvince(province);
      msg.setCity(city);
      msg.setZone(districtName);
      msg.setExpireDays("28");
      msg.setMobile(mobilephone);
      msg.setTelephone(telephone);
      msg.setQq(qq);
      msg.setMsn(msn);
      msg.setEmail(email);
      msg.setPictureUrl1(picture);
      msg.setNotifyEmail(email != null ? email : msn);
      msg.setSourceUrl(session.getLastUrl().toExternalForm());

      try {
         m_connector.publish(action, msg);
      } catch (Exception e) {
         e.printStackTrace();
      }

      if (DEBUG) {
         System.out.println(msg.toString().replace("\r\n", "\\r\\n"));
      }
   }
}
