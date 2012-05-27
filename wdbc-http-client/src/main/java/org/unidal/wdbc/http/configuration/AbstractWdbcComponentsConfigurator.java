package org.unidal.wdbc.http.configuration;

import java.util.List;

import com.site.lookup.configuration.AbstractResourceConfigurator;
import com.site.lookup.configuration.Component;
import com.site.lookup.configuration.Configuration;
import org.unidal.wdbc.WdbcQuery;
import org.unidal.wdbc.http.Flow;
import org.unidal.wdbc.http.Processor;
import org.unidal.wdbc.http.Request;
import org.unidal.wdbc.http.Session;
import org.unidal.wdbc.http.impl.DefaultFlow;
import org.unidal.wdbc.http.impl.DefaultSession;
import org.unidal.wdbc.http.impl.FormRequest;
import org.unidal.wdbc.query.WdbcFilter;

public abstract class AbstractWdbcComponentsConfigurator extends AbstractResourceConfigurator {

   public static Component F() {
      return C(Flow.class, DefaultFlow.class);
   }

   public static Component P(Class<? extends Processor> processorClass) {
      return C(Processor.class, processorClass);
   }

   public static Configuration P(String name, String path) {
      return E("path", "name", name).value(path);
   }

   public static Component Q(String roleHint, Class<? extends WdbcQuery> queryClass) {
      return C(WdbcQuery.class, roleHint, queryClass);
   }

   public static Component R(String roleHint) {
      return C(Request.class, roleHint, FormRequest.class);
   }

   public static RequestQueryFilter RQ(String roleHint) {
      return new RequestQueryFilter(roleHint);
   }

   public static RequestQueryFilter RQF(String roleHint, Class<? extends WdbcFilter> filterClass) {
      return new RequestQueryFilter(roleHint, filterClass);
   }

   public static Component S() {
      return C(Session.class, DefaultSession.class);
   }

   public static List<Component> WDBC(Class<?> wdbcClass) {
      return new WdbcComponentsConfigurator(wdbcClass).defineComponents();
   }
}
