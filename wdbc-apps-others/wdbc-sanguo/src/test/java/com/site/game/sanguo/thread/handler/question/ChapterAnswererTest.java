package com.site.game.sanguo.thread.handler.question;

import com.site.lookup.ComponentTestCase;

public class ChapterAnswererTest extends ComponentTestCase {
   public void testAnswer() throws Exception {
      Answerer answerer = lookup(Answerer.class, "chapter");

      assertTrue(answerer.canAnswer("����ɽ�ع�Լ���� �Ȱ���ܲٽ���Χ ���������ڼ���"));
      assertEquals(2, answerer.answer("����ɽ�ع�Լ���� �Ȱ���ܲٽ���Χ ���������ڼ���", new String[] { "24", "25", "26", "27" }));
   }
}
