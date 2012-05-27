package org.unidal.wdbc.baixing;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DetailsFilter extends DefaultWdbcFilter {

   @Override
   public void doFilter(WdbcResult result) {
      super.doFilter(result);

      aggregate(result, "\r\n");
   }

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String desc = (String) result.getCell(row, "desc");

      if (desc == null || desc.length() == 0) {
         return true;
      } else {
         if (desc.equals("ע����½�û��������ʣ�")) {
            return true;
         } else if (desc.contains("����Ϣ��ʱû��")) {
            return true;
         } else if (desc.startsWith("ver. r")) {
            return true;
         }

         return false;
      }
   }
}
