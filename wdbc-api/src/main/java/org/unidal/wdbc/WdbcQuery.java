package org.unidal.wdbc;

import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.path.WdbcTagTree;

public interface WdbcQuery {
   void handleEvent(WdbcContext context, WdbcResult result,
         WdbcEventType eventType);

   public String getName();

   public void setName(String name);

   public WdbcTagTree buildTagTree();
}
