package org.unidal.wdbc.linkedin;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class ProfileFilter extends DefaultWdbcFilter {

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String profile = (String) result.getCell(row, "profile");

      if ("View public profile".equals(profile)) {
         return false;
      }

      return true;
   }
}
