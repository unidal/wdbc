package com.site.game.sanguo.thread.wdbc.filter;

import java.text.MessageFormat;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class VillageDetailFilter extends DefaultWdbcFilter {
   private MessageFormat m_format = new MessageFormat("{0}�ơ�����{1} �����ˣ� ������ �ӡ���{2} ����λ��{3}");

   @Override
   public void doFilter(WdbcResult result) {
      aggregate(result, " ");

      super.doFilter(result);
   }

   @Override
   protected boolean shouldRemoveRow(WdbcResult result, int row) {
      String village = (String) result.getCell(row, "village");
      String tribe = (String) result.getCell(row, "tribe");

      if (village != null && tribe != null) {
         try {
            Object[] parts = m_format.parse(tribe);

            result.setValue(row, "village", village.split(" ")[0]);
            result.setValue(row, "tribe", parts[1]);
            result.setValue(row, "population", parts[2]);

            return false;
         } catch (Exception e) {
            // ignore it
         }
      }

      return true;
   }
}
