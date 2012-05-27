package org.unidal.wdbc.http.cache;

import java.io.IOException;
import java.net.URL;

import org.unidal.wdbc.http.Response;

public interface CacheManager {
   public boolean supportCache(URL url);

   public Response getCache(URL url) throws IOException;

   public void setCache(URL url, Response response) throws IOException;
}
