package org.unidal.wdbc.query;

import org.unidal.wdbc.WdbcResult;

public interface WdbcFilter {
   public void doFilter(WdbcResult result);
}
