package org.unidal.wdbc.ebay.arch;

import com.site.lookup.annotation.Inject;
import org.unidal.wdbc.http.Processor;
import org.unidal.wdbc.http.Session;

public class CourseProcessor implements Processor {
   @Inject
   private ResultHandler m_handler;

   public void execute(Session session) {
      String title = session.getProperties().get("course:title");

      m_handler.handleCourse(title);
   }
}
