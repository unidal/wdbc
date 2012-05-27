package org.unidal.wdbc;

import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.path.TagTree;
import org.unidal.wdbc.query.path.WdbcTagTree;

public class DomQuery implements WdbcQuery {
   private String m_name;

   public WdbcTagTree buildTagTree() {
      return TagTree.buildTree(null, true);
   }

   public String getName() {
      return m_name;
   }

   public void handleEvent(WdbcContext context, WdbcResult result, WdbcEventType eventType) {
      switch (eventType) {
      case START_TAG:
         System.out.println("start: " + context.getTagName());
         break;
      case END_TAG:
         System.out.println("end: " + context.getTagName());
         break;
      case TEXT:
         System.out.println("text: " + context.getText());
      default:
      }
   }

   public void setName(String name) {
      m_name = name;
   }
}
