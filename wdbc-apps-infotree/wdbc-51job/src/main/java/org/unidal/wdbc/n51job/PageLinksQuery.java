package org.unidal.wdbc.n51job;

import java.text.MessageFormat;

import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.WdbcFilter;
import org.unidal.wdbc.query.path.TagTree;
import org.unidal.wdbc.query.path.WdbcTagTree;

public class PageLinksQuery implements WdbcQuery {
   private WdbcFilter m_filter;

   private Configuration m_configuration;

   private String m_name;

   private String m_uriPattern;

   private String m_postDataPattern;

   public WdbcTagTree buildTagTree() {
      return TagTree.buildTree(null, false);
   }

   public String getName() {
      return m_name;
   }

   public void handleEvent(WdbcContext context, WdbcResult result, WdbcEventType eventType) {
      switch (eventType) {
      case START_DOCUMENT:
         String[] columns = new String[] { "link", "post-data" };

         result.begin(columns);
         break;
      case END_DOCUMENT:
         result.applyLastRow();

         if (m_filter != null) {
            m_filter.doFilter(result);
         }

         break;
      default:
         if (result.getRowSize() == 0) { // only add once
            MessageFormat uriFormat = new MessageFormat(m_uriPattern);
            MessageFormat postDataFormat = new MessageFormat(m_postDataPattern);
            String city = m_configuration.getCityId();
            String category = m_configuration.getCategory();
            int maxPages = m_configuration.getMaxPages();

            for (int page = 1; page <= maxPages; page++) {
               String link = uriFormat.format(new Object[] { category, page, city });
               String postData = postDataFormat.format(new Object[] { category, page, city });

               result.addValue("link", link);
               result.addValue("post-data", postData);
            }
         }
      }
   }

   public void setName(String name) {
      m_name = name;
   }

   public void setUriPattern(String uriPattern) {
      m_uriPattern = uriPattern;
   }
   
   public void setPostDataPattern(String postDataPattern) {
      m_postDataPattern = postDataPattern;
   }
}
