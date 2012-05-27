package org.unidal.wdbc.http.cache;

import java.net.URL;

import org.unidal.wdbc.http.Response;

public class NoCacheManager implements CacheManager {
   public Response getCache(URL url) {
      return null;
   }

   public void setCache(URL url, Response response) {
      // do nothing
   }

   public boolean supportCache(URL url) {
      return false;
   }
}
