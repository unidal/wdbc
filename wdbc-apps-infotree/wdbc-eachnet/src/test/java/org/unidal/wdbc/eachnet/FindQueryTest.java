package org.unidal.wdbc.eachnet;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

public class FindQueryTest extends ComponentTestCase {
   public void testList() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "list");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/list.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(35, result.getRowSize());
   }
// TODO
//   public void testNextPage() throws Exception {
//      WdbcQuery query = lookup(WdbcQuery.class, "next-page");
//      assertNotNull(query);
//      
//      WdbcEngine engine = lookup(WdbcEngine.class);
//      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/list.html");
//      WdbcResult result = engine.execute(query, source);
//      
//      assertNotNull(result);
//      assertEquals(result.getRowSize(), 4);
//   }
   
   public void testDescription() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "description");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(2, result.getRowSize());
   }
   
   public void testDetails() throws Exception {
      WdbcQuery query = lookup(WdbcQuery.class, "details");
      assertNotNull(query);
      
      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details.html");
      WdbcResult result = engine.execute(query, source);
      
      assertNotNull(result);
      assertEquals(2, result.getRowSize());
   }

}
