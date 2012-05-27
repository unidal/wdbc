package org.unidal.wdbc.state;

import java.sql.SQLException;
import java.util.Map;

import org.unidal.wdbc.http.Processor;
import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.linkedin.DatabaseAccess;

public class StateProcessor implements Processor {
   private DatabaseAccess m_databaseAccess;

   public void execute(Session session) {
      Map<String, String> prop = session.getProperties();
      String state = prop.get("state-links:state");
      String zipcode = prop.get("state-zipcode:zipcode");

      try {
         m_databaseAccess.insertLocation(zipcode, state);
      } catch (SQLException e) {
         System.err.println(e.toString());
      }
   }
}
