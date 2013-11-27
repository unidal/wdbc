package org.unidal.wdbc.cat;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class DomainFilter extends DefaultWdbcFilter {
	@Override
	protected boolean shouldRemoveRow(WdbcResult result, int row) {
		String domain = (String) result.getCell(row, "domain");

		if (domain != null && domain.startsWith("[ ") && domain.endsWith(" ]")) {
			result.setValue(row, "domain", domain.substring(2, domain.length() - 2));
		}

		return false;
	}
}
