package org.unidal.wdbc.qm120;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DetailsFilter extends DefaultWdbcFilter {
   @Override
   public void doFilter(WdbcResult result) {
      String address = aggregate(result, "address", null);
      String zipcode = aggregate(result, "zipcode", null);
      String telephone = aggregate(result, "telephone", null);

      String contact = address+" "+zipcode;

      result.clear();
      result.addValue("contact", contact);
      result.addValue("address", address);
      result.addValue("zipcode", zipcode);
      result.addValue("telephone", telephone);
      result.applyLastRow();
   }
}
