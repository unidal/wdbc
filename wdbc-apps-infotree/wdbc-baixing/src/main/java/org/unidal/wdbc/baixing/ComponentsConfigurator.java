package org.unidal.wdbc.baixing;

import java.util.ArrayList;
import java.util.List;

import com.site.lookup.configuration.Component;
import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.http.configuration.AbstractWdbcComponentsConfigurator;
import org.unidal.wdbc.infotree.InfoTreeConnector;

public class ComponentsConfigurator extends AbstractWdbcComponentsConfigurator {
   public static void main(String[] args) {
      generatePlexusComponentsXmlFile(new ComponentsConfigurator());
   }

   @Override
   public List<Component> defineComponents() {
      List<Component> all = new ArrayList<Component>();

      all.add(S().config(
               E("headers").add(
                  E("header", "name", "User-Agent")
                     .value("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 1.1.4322)")
               )));

      all.add(C(Configuration.class).config(E("config").value("config.xml")));
      
      all.add(P(Processor.class).req(Configuration.class, InfoTreeConnector.class));
      
      all.add(F().config(
                  E("handler", "query", "page-links", "interval", "2").add(
                     E("page", "name", "list"),
                     E("handler", "query", "list", "interval", "2").add(
                        E("page", "name", "details"),
                        E("handler", "query", "details").add(
                           E("processor", "name", "default")
                  )))));

      all.add(Q("page-links", PageLinksQuery.class)
               .config(E("uriPattern").value("http://{2}.baixing.com/{0}/?page={1}"))
               .req(Configuration.class));

      all.addAll(RQF("list", ListFilter.class)
               .rconfig(E("action").value("${page-links:link}"))
               .qconfig(E("paths").add(
                        P("id", "-"),
                        P("date", "table[*].tr[2-].td[4]"),
                        P("link", "table[*].tr[2-].td[2].div.a.@href"),
                        P("title", "table[*].tr[2-].td[2].div.a"),
                        null))
               .freq(Session.class)
               .getComponents());

      all.addAll(RQF("details", DetailsFilter.class)
               .rconfig(E("action").value("${list:link}"))
               .qconfig(E("paths").add(
                        P("desc", "p[*].*text"),
                        null))
               .getComponents());
      
      return all;
   }
}
