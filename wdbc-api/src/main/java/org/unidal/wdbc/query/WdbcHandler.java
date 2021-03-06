package org.unidal.wdbc.query;

import java.util.Map;

import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;

public interface WdbcHandler {
   public void handleComment(String comment);

   public void handleEndDocument();

   public void handleEndTag(String tagName);

   public void handleError(String message, Throwable cause);

   public void handleStartTag(String tagName, Map<String, String> attributes);

   public void handleStartDocument();

   public void handleText(String text);

   public WdbcResult getResult();

   public void setQuery(WdbcQuery query);

}
