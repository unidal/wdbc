package org.unidal.wdbc;

public interface WdbcEngine {
   public WdbcResult execute(WdbcQuery query, WdbcSource source) throws WdbcException;
}
