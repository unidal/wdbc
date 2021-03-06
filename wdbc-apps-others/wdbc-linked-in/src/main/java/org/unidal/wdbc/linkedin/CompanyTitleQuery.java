package org.unidal.wdbc.linkedin;

import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.WdbcFilter;
import org.unidal.wdbc.query.path.TagTree;
import org.unidal.wdbc.query.path.WdbcTagTree;

public class CompanyTitleQuery implements WdbcQuery {
   private DatabaseAccess m_databaseAccess;

   private WdbcFilter m_filter;

   private String m_name;

   private String[] m_companies;

   private String[] m_titles;

   public WdbcTagTree buildTagTree() {
      return TagTree.buildTree(null, false);
   }

   public String getName() {
      return m_name;
   }

   public void handleEvent(WdbcContext context, WdbcResult result, WdbcEventType eventType) {
      switch (eventType) {
      case START_DOCUMENT:
         String[] columns = new String[] { "company", "title" };

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
            for (String company : m_companies) {
               for (String title : m_titles) {
                  if (!m_databaseAccess.isDone(company, title)) {
                     result.addValue(0, company);
                     result.addValue(1, title);
                  }
               }
            }
         }
      }
   }

   public void setName(String name) {
      m_name = name;
   }

   public void setCompanies(String[] companies) {
      m_companies = companies;
   }

   public void setTitles(String[] titles) {
      m_titles = titles;
   }
}
