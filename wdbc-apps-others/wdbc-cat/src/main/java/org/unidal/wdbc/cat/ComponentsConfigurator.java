package org.unidal.wdbc.cat;

import java.util.ArrayList;
import java.util.List;

import org.unidal.wdbc.http.configuration.AbstractWdbcComponentsConfigurator;

import com.site.lookup.configuration.Component;

public class ComponentsConfigurator extends AbstractWdbcComponentsConfigurator {
	public static void main(String[] args) {
		generatePlexusComponentsXmlFile(new ComponentsConfigurator());
	}

	@Override
	public List<Component> defineComponents() {
		List<Component> all = new ArrayList<Component>();

		all.add(S().config( //
		      E("headers").add( //
		            E("header", "name", "User-Agent").value( //
		                  "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; .NET CLR 1.1.4322)") //
		            )));

		all.add(C(Configuration.class) //
		      .config(E("config").value("config.xml")));

		all.add(P(Processor.class) //
		      .req(Configuration.class));

		all.add(F().config( //
		      E("handler", "query", "page-links", "interval", "2").add( //
		            E("page", "name", "domain"), //
		            E("handler", "query", "transaction", "interval", "2").add( //
		                  E("processor", "name", "default") //
		                  ))));

		all.add(Q("page-links", PageLinksQuery.class) //
		      .config(E("uriPattern").value("http://cat.dianpingoa.com/cat/r/t?op=history&domain=Cat&reportType=day")));

		all.addAll(RQF("domain", DomainFilter.class) //
		      .rconfig(E("action").value("${page-links:link}")) //
		      .qconfig(E("paths").add( //
		            P("domain", "html.body.div[2].table[2].tr.td.div.a[*]"), //
		            null)) //
		      .getComponents());

		all.addAll(RQF("transaction", TransactionFilter.class) //
		      .rconfig(
		            E("action").value(
		                  "http://cat.dianpingoa.com/cat/r/t?op=history&domain=${page-links:domain}&reportType=day")) //
		      .qconfig(E("paths").add( //
		            P("type", "html.body.div[2].table[3].tr[*].td.a[2]"), //
		            P("total", "html.body.table[5].tr[*].td[2]"), //
		            P("failure", "html.body.table[5].tr[*].td[3]"), //
		            P("avg", "html.body.table[5].tr[*].td[8]"), //
		            null)) //
		      .getComponents());

		return all;
	}
}
