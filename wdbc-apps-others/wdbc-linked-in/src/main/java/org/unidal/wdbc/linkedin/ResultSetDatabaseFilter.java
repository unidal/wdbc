package org.unidal.wdbc.linkedin;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;
import org.unidal.wdbc.query.WdbcFilter;

public class ResultSetDatabaseFilter extends DefaultWdbcFilter {
   private WdbcFilter m_filter;

   private DatabaseAccess m_databaseAccess;

   @Override
   public void doFilter(WdbcResult result) {
      if (m_filter != null) {
         m_filter.doFilter(result);
      }

      super.doFilter(result);
   }

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String id = (String) result.getCell(row, "id");

      if (id != null && m_databaseAccess.hasEmployee(id)) {
         return true;
      } else {
         return false;
      }
   }
}
