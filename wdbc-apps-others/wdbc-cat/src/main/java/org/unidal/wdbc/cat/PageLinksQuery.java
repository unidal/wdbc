package org.unidal.wdbc.cat;

import java.text.MessageFormat;

import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.WdbcResult;
import org.unidal.wdbc.query.WdbcContext;
import org.unidal.wdbc.query.WdbcEventType;
import org.unidal.wdbc.query.WdbcFilter;
import org.unidal.wdbc.query.path.TagTree;
import org.unidal.wdbc.query.path.WdbcTagTree;

public class PageLinksQuery implements WdbcQuery {
	private WdbcFilter m_filter;

	private String m_name;

	private String m_uriPattern;

	public WdbcTagTree buildTagTree() {
		return TagTree.buildTree(null, false);
	}

	public String getName() {
		return m_name;
	}

	public void handleEvent(WdbcContext context, WdbcResult result,
			WdbcEventType eventType) {
		switch (eventType) {
		case START_DOCUMENT:
			String[] columns = new String[] { "link" };

			result.begin(columns);
			break;
		case END_DOCUMENT:
			result.applyLastRow();

			if (m_filter != null) {
				m_filter.doFilter(result);
			}

			break;
		default:
			if (result.getRowSize() == 0) { // only add once
				MessageFormat format = new MessageFormat(m_uriPattern);
				String link = format.format(new Object[] {});

				result.addValue("link", link);
			}
		}
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setUriPattern(String uriPattern) {
		m_uriPattern = uriPattern;
	}
}
