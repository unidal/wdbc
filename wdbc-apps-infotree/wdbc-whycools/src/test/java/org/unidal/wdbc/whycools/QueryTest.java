package org.unidal.wdbc.whycools;

import java.net.URL;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;
import org.unidal.wdbc.http.Session;

public class QueryTest extends ComponentTestCase {
   public void testList() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "list");
      assertNotNull(query);
      
      Session session = lookup(Session.class);
      session.setLastUrl(new URL("http://www.whycools.com/chaxun/cpch.asp?1=1"));

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "pages/list.html", "utf-8");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(30, result.getRowSize());
   }

   public void testDetails() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "details");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "pages/details.html", "utf-8");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(1, result.getRowSize());
   }
   
   public void testEmail() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "email");
      assertNotNull(query);
      
      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "pages/details.html", "utf-8");
      WdbcResult result = engine.execute(query, source);
      
      assertNotNull(result);
      assertEquals(1, result.getRowSize());
   }
}
