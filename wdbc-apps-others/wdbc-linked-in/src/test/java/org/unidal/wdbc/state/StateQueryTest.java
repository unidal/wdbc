package org.unidal.wdbc.state;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

public class StateQueryTest extends ComponentTestCase {
   public void testStateLinks() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);
      assertNotNull(engine);

      WdbcQuery query = lookup(WdbcQuery.class, "state-links");
      assertNotNull(query);

      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/state.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(51, result.getRowSize());
   }

   public void testStateZipCode() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);
      assertNotNull(engine);

      WdbcQuery query = lookup(WdbcQuery.class, "state-zipcode");
      assertNotNull(query);

      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/zipcode.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(837, result.getRowSize());
   }
}
