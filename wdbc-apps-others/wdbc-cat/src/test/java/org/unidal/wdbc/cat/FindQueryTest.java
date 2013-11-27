package org.unidal.wdbc.cat;

import org.unidal.wdbc.ResourceSource;
import org.unidal.wdbc.WdbcEngine;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.WdbcSource;
import org.unidal.wdbc.WdbcSourceType;

import com.site.lookup.ComponentTestCase;

public class FindQueryTest extends ComponentTestCase {
	public void testDomain() throws Exception {
		WdbcQuery query = lookup(WdbcQuery.class, "domain");
		assertNotNull(query);

		WdbcEngine engine = lookup(WdbcEngine.class);
		WdbcSource source = new ResourceSource(WdbcSourceType.HTML,
				"/pages/transaction.html");
		WdbcResult result = engine.execute(query, source);

		assertNotNull(result);
		assertEquals(2, result.getRowSize());
	}

	public void testTransaction() throws Exception {
		WdbcQuery query = lookup(WdbcQuery.class, "transaction");
		assertNotNull(query);

		WdbcEngine engine = lookup(WdbcEngine.class);
		WdbcSource source = new ResourceSource(WdbcSourceType.HTML,
				"/pages/transaction.html");
		WdbcResult result = engine.execute(query, source);

		System.out.println(result);
		assertNotNull(result);
		assertEquals(3, result.getRowSize());
	}
}