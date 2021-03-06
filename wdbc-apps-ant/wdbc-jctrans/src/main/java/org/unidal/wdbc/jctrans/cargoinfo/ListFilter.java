package org.unidal.wdbc.jctrans.cargoinfo;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class ListFilter extends DefaultWdbcFilter {
   private Session m_session;

   private SimpleDateFormat m_date = new SimpleDateFormat("yyyy-M-d");
   private SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd");

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String title = (String) result.getCell(row, "title");
      String link = (String) result.getCell(row, "link");
      String date = (String) result.getCell(row, "date");

      if (link == null || title == null || date == null) {
         return true;
      } else {
         try {
            if (m_session != null) {
               link = new URL(m_session.getLastUrl(), link).toExternalForm();
            }
         } catch (Exception e) {
            // ignore it
         }

         int pos1 = link.lastIndexOf('_');
         int pos2 = link.lastIndexOf('.');

         if (pos1 > 0 && pos2 > pos1) {
            result.setValue(row, "id", link.substring(pos1 + 1, pos2));
         } else {
            return true;
         }

         try {
            result.setValue(row, "date", m_format.format(m_date.parse(date)));
         } catch (ParseException e) {
            // ignore it
         }

         result.setValue(row, "link", link);
         return false;
      }
   }
}
