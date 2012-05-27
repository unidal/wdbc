package org.unidal.wdbc.useragent;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.FindQuery;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

public class FindQueryTest extends ComponentTestCase {
   public void testList() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "list");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/useragents.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(426, result.getRowSize());
   }

}
