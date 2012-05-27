package org.unidal.wdbc.query;

import static org.unidal.wdbc.WdbcSourceType.HTML;

import com.site.lookup.ComponentTestCase;
import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcSource;

public class HtmlToXmlTest extends ComponentTestCase {
   public void testConvert() throws Exception {
      WdbcSource source = new ResourceSource(HTML, "/pages/details2.html");
      HtmlToXmlConverter converter = new HtmlToXmlConverter();

      String result = converter.convert(source.getReader());

      assertNotNull(result);
   }
}
