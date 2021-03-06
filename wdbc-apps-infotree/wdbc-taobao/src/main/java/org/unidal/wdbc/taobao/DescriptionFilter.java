package org.unidal.wdbc.taobao;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DescriptionFilter extends DefaultWdbcFilter {

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String description = (String) result.getCell(row, "description");

      if (description == null) {
         return true;
      } else {
         if (description.startsWith("var desc='")) {
            description = description.substring("var desc='".length());
         }

         if (description.endsWith("';")) {
            description = description.substring(0, description.length() - 2);
         }

         result.setValue(row, "description", description);
         return false;
      }
   }
}
