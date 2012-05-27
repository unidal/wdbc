package org.unidal.wdbc.linkedin;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class PageLinksFilter extends DefaultWdbcFilter {
   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      try {
         String num = (String) result.getCell(row, "num");

         Integer.parseInt(num);
         return false;
      } catch (Exception e) {
         // It's NOT a number, remove it
         return true;
      }
   }

}
