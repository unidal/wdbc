package org.unidal.wdbc.http.configuration;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.unidal.wdbc.query.DefaultWdbcFilter;
import org.unidal.wdbc.query.WdbcFilter;

@Retention(RUNTIME)
@Target(TYPE)
public @interface WdbcMeta {
   String name();

   Class<? extends WdbcFilter> filter() default DefaultWdbcFilter.class;
}
