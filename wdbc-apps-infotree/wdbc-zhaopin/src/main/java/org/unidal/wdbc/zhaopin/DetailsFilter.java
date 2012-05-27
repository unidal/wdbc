package org.unidal.wdbc.zhaopin;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DetailsFilter extends DefaultWdbcFilter {

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String desc = (String) result.getCell(row, "desc");

      if (desc == null) {
         return true;
      } else {
         desc = desc.replace("[ְλ��Ϣ�ղ�]", "");
         desc = desc.replace("[�ù�˾����ְλ]", "");
         desc = desc.replace("[���ܸ�����]", "");

         result.setValue(row, "desc", desc);

         return false;
      }
   }
}
