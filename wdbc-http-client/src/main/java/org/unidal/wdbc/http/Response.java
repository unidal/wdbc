package org.unidal.wdbc.http;

import java.io.IOException;
import java.io.InputStream;

import org.unidal.wdbc.WdbcSourceType;

public interface Response {
   public String getCharset();

   public InputStream getContent() throws IOException;

   public WdbcSourceType getContentType();
}
