package org.unidal.wdbc.ganji;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.http.Flow;

public class FlowTest extends ComponentTestCase {
   public void testFlow() throws Exception {
      Flow flow =  lookup(Flow.class);

      assertNotNull(flow);
      flow.execute();
   }
}
