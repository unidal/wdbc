package org.unidal.wdbc.kijiji;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.FindQuery;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

public class FindQueryTest extends ComponentTestCase {
   public void testPrime() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "prime");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/prime.html");

      WdbcResult result = engine.execute(query, source);
      assertNotNull(result);
      assertEquals(5, result.getRowSize());
   }

   public void testList() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "list");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/list.html");

      WdbcResult result = engine.execute(query, source);
      assertNotNull(result);
      assertEquals(4, result.getRowSize());
   }

   public void testDetails() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "details");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details.html");

      WdbcResult result = engine.execute(query, source);
      assertNotNull(result);
      assertEquals(3, result.getRowSize());
   }
}
