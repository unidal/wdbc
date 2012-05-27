package org.unidal.wdbc.query;

import org.unidal.wdbc.WdbcException;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;

public interface WdbcParser {
   public WdbcResult parse(WdbcHandler handler, WdbcSource source)
         throws WdbcException;
}
