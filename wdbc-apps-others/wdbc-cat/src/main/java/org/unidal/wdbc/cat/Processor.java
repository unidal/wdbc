package org.unidal.wdbc.cat;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.unidal.wdbc.http.Session;

public class Processor implements org.unidal.wdbc.http.Processor, Initializable {
	private Configuration m_configuration;

	private Map<String, Transaction> m_transactions = new HashMap<String, Transaction>();

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
		String title = prop.get("list:title");
		String zone = prop.get("details:district");
		String address = prop.get("list:address");
		String desc = prop.get("details:desc");
		String mobilephone = prop.get("details:mobilephone");
		String telephone = prop.get("details:telephone");
		String qq = prop.get("details:qq");
		String msn = prop.get("details:msn");
		String email = prop.get("details:email");
		String contactInfo = prop.get("details:contact");
		String picture = prop.get("details:picture");

		InfoTreeMessage msg = new InfoTreeMessage();

		msg.setUsername(username);
		msg.setPassword(password);
		msg.setTitle(title);
		msg.setContent(address + "\r\n\r\n" + (desc == null ? "" : desc) + "\r\n\r\n"
		      + (contactInfo == null ? "" : contactInfo));
		msg.setType(type);
		msg.setCategory(category);
		msg.setProvince(province);
		msg.setCity(city);
		msg.setZone(zone);
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

	public static class Transaction {
		private String m_type;

		private int m_total;

		private int m_failure;

		private double m_avg;

		public Transaction(Map<String, String> prop) {
			m_type = prop.get("transaction:type");
		}

		public String getType() {
			return m_type;
		}

		public int getTotal() {
			return m_total;
		}

		public int getFailure() {
			return m_failure;
		}

		public double getAvg() {
			return m_avg;
		}
	}
}
