package org.unidal.wdbc.http;

import org.unidal.wdbc.WdbcException;

public interface Flow {
   public void execute() throws WdbcException;
}
