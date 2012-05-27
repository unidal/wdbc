package org.unidal.wdbc;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.query.WdbcHandler;

public class WdbcHandlerTest extends ComponentTestCase {
   public void testLookup() throws Exception {
      WdbcHandler handler = lookup(WdbcHandler.class);

      assertNotNull(handler);
      assertNotNull(handler.getResult());
   }
}
