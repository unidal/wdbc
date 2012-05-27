package org.unidal.wdbc.state;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.http.Flow;

public class StateFlowTest extends ComponentTestCase {
   public void testFlow() throws Exception {
      Flow flow = lookup(Flow.class, "us-states");

      assertNotNull(flow);

      flow.execute();
   }
}
