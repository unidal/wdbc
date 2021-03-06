package org.unidal.wdbc.zhaopin;

import java.net.URL;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class ListFilter extends DefaultWdbcFilter {
   private Session m_session;

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String title = (String) result.getCell(row, "title");
      String link = (String) result.getCell(row, "link");

      if (link == null || title == null) {
         return true;
      } else {
         try {
            if (m_session != null) {
               link = new URL(m_session.getLastUrl(), link).toExternalForm();
            }
         } catch (Exception e) {
            // ignore it
         }

         result.setValue(row, "link", link);
         return false;
      }
   }
}
