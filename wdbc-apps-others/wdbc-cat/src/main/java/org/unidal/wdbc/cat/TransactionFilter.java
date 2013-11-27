package org.unidal.wdbc.cat;

import java.text.DecimalFormat;

import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.DefaultWdbcFilter;

public class TransactionFilter extends DefaultWdbcFilter {
	private DecimalFormat m_format = new DecimalFormat("###,###,###,##0");

	@Override
	protected boolean shouldRemoveRow(WdbcResult result, int row) {
		String total = (String) result.getCell(row, "total");
		String failure = (String) result.getCell(row, "failure");
		String avg = (String) result.getCell(row, "avg");

		if (total != null) {
			try {
				result.setValue(row, "total", m_format.parse(total));
			} catch (Exception e) {
				result.setValue(row, "total", 0);
				e.printStackTrace();
			}
		}

		if (failure != null) {
			try {
				result.setValue(row, "failure", Integer.parseInt(failure));
			} catch (Exception e) {
				result.setValue(row, "failure", 0);
				e.printStackTrace();
			}
		}

		if (avg != null) {
			try {
				result.setValue(row, "avg", Double.parseDouble(avg));
			} catch (Exception e) {
				result.setValue(row, "avg", 0);
				e.printStackTrace();
			}
		}

		return false;
	}
}
