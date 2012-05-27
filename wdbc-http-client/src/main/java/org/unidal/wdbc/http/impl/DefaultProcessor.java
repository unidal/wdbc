package org.unidal.wdbc.http.impl;

import org.unidal.wdbc.http.Processor;
import org.unidal.wdbc.http.Session;

public class DefaultProcessor implements Processor {
   public void execute(Session session) {
      System.out.println(session.getProperties());
   }
}
