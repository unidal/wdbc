package org.unidal.wdbc.http;

import java.util.List;

import org.unidal.wdbc.WdbcException;
import org.unidal.wdbc.WdbcQuery;

public interface Handler {
   public void addRequest(Request request);

   public void execute(Session session) throws WdbcException;

   public void setChildren(List<Handler> children);

   public void setHandleCurrentPage(boolean handleCurrentPage);

   public void setInterval(long seconds);

   public void setProcessor(Processor processor);

   public void setQuery(WdbcQuery query);
}
