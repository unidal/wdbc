package org.unidal.wdbc.whycools;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class EmailFilter extends DefaultWdbcFilter {
   @Override
   public void doFilter(WdbcResult result) {
      String email = aggregate(result, "email", "@");

      result.clear();
      result.addValue("email", email);
      result.applyLastRow();
   }
}
