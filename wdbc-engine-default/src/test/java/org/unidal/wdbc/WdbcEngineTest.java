package org.unidal.wdbc;

import static org.unidal.wdbc.WdbcSourceType.HTML;
import static org.unidal.wdbc.WdbcSourceType.XML;

import java.util.ArrayList;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.path.PathPattern;
import org.unidal.wdbc.query.path.TagTree;
import org.unidal.wdbc.query.path.WdbcTagTree;

public class WdbcEngineTest extends ComponentTestCase {
   static boolean DEBUG = false;

   public void testExecuteForHtml() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);

      assertNotNull(engine);

      WdbcQuery query = new WdbcQueryMock();
      WdbcSource source = new StringSource(HTML, "<html><body>this is body<p>This is paragraph</p></body></html>");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testExecuteForXml() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);

      assertNotNull(engine);

      WdbcQuery query = new WdbcQueryMock();
      WdbcSource source = new StringSource(XML, "<html><body>this is body<p>This is paragraph</p></body></html>");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
   }

   public void testExecuteSample() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);

      assertNotNull(engine);

      WdbcQuery query = lookup(WdbcQuery.class, "sample");
      WdbcSource source = new StringSource(HTML, "<html><body><table border=\"0\">"
            + "<tr id=\"1\"><td>11</td><td>12</td><td>13</td></tr>"
            + "<tr id=\"2\"><td>21</td><td>22</td><td>23</td></tr>"
            + "<tr id=\"3\"><td>31</td><td>32</td><td>33</td></tr>" + "</table></body></html>");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(3, result.getRowSize());
   }

   public void testFormInputs() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);
      assertNotNull(engine);

      WdbcQuery query = lookup(WdbcQuery.class, "form");
      assertNotNull(query);

      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/form.html");
      WdbcResult result = engine.execute(query, source);

      assertNotNull(result);
      assertEquals(14, result.getRowSize());
   }
   
   public void testFormInputs2() throws Exception {
      WdbcEngine engine = lookup(WdbcEngine.class);
      assertNotNull(engine);
      
      WdbcQuery query = lookup(WdbcQuery.class, "form2");
      assertNotNull(query);
      
      WdbcSource source = new ResourceSource(WdbcSourceType.HTML, "/pages/form.html");
      WdbcResult result = engine.execute(query, source);
      
      System.out.println(result);
      assertNotNull(result);
      assertEquals(14, result.getRowSize());
   }

   static final class WdbcQueryMock implements WdbcQuery {
      private String m_name;

      public WdbcTagTree buildTagTree() {
         return TagTree.buildTree(new ArrayList<PathPattern>(), false);
      }

      public String getName() {
         return m_name;
      }

      public void handleEvent(WdbcContext ctx, WdbcResult result, WdbcEventType eventType) {
         if (DEBUG) {
            System.out.println("[" + ctx + "] " + eventType + " " + (ctx.getText() == null ? "" : ctx.getText())
                  + (ctx.getComment() == null ? "" : ctx.getComment()));
         }

         if (eventType == WdbcEventType.START_DOCUMENT) {
            result.begin(new String[] {});
         }
      }

      public void setName(String name) {
         m_name = name;
      }
   }
}
