package org.unidal.wdbc.linkedin;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.FindQuery;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

public class FindQueryTest extends ComponentTestCase {
   public void testProfile() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "profile");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testDetails() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "details");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testDetails2() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "details2");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/details2.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testPage() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "page");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/page.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testState() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "state");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/state.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testZipCode() throws Exception {
      FindQuery query = (FindQuery) lookup(WdbcQuery.class, "zipcode");
      assertNotNull(query);

      WdbcEngine engine = lookup(WdbcEngine.class);
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/zipcode.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }
}
