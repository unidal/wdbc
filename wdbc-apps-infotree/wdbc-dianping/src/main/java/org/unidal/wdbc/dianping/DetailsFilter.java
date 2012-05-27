package org.unidal.wdbc.dianping;

import java.text.MessageFormat;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DetailsFilter extends DefaultWdbcFilter {

   private MessageFormat m_bodyFormat = new MessageFormat("�̻����:\r\n{0}\r\n�Ƽ���:\r\n{1}\r\n{2}");

   @Override
   public void doFilter(WdbcResult result) {
      String title = aggregate(result, "title", null);
      String desc = aggregate(result, "desc", null);
      String dish = aggregate(result, "dish", " ");
      String dish2 = aggregate(result, "dish2", " ");
      String category = aggregate(result, "category", " > ");
      String district = aggregate(result, "district", " - ");
      String picture = aggregate(result, "picture", null);
      String contact = aggregate(result, "contact", null);
      String mobilephone = null;
      String telephone = null;

      int rows = result.getRowSize();
      boolean hasPhone = false;

      for (int row = 0; row < rows; row++) {
         String cell = (String) result.getCell(row, "contact");

         if (cell != null) {
            if ("�绰:".equals(cell)) {
               hasPhone = true;
            } else if (hasPhone) {
               if (cell.length() > 0 && cell.charAt(0) == 160) {
                  cell = cell.substring(1);
               }

               if (cell.startsWith("1")) {
                  mobilephone = cell;
               } else {
                  telephone = cell;
               }

               break;
            }
         }
      }

      if (desc.contains("(��ֲ��ֿܵ����)")) {
         desc = "";
      }

      result.clear();
      result.addValue("title", title);

      if (dish.length() > 0) { // has desc
         result.addValue("body", m_bodyFormat.format(new Object[] { desc, dish, contact }));
      } else if (dish2.length() > 0) { // without dish
         result.addValue("body", m_bodyFormat.format(new Object[] { "", dish2, contact }));
      }

      result.addValue("contact", contact);
      result.addValue("category", category);
      result.addValue("district", district);
      result.addValue("picture", picture);
      result.addValue("mobilephone", mobilephone);
      result.addValue("telephone", telephone);
      result.applyLastRow();
   }
}
