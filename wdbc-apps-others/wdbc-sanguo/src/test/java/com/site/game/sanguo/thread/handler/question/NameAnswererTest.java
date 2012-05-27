package com.site.game.sanguo.thread.handler.question;

import com.site.lookup.ComponentTestCase;

public class NameAnswererTest extends ComponentTestCase {
   public void testAnswer() throws Exception {
      Answerer answerer = lookup(Answerer.class, "name");

      assertTrue(answerer.canAnswer("����  ������ʲô?"));
      assertEquals(2, answerer.answer("����  ������ʲô?", new String[] { "������", "����Т", "�ֲ���", "������" }));
   }
}
