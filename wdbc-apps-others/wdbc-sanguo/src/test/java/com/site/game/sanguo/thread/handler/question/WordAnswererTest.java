package com.site.game.sanguo.thread.handler.question;

import com.site.lookup.ComponentTestCase;

public class WordAnswererTest extends ComponentTestCase {
   public void testAnswer() throws Exception {
      Answerer answerer = lookup(Answerer.class, "word");

      assertTrue(answerer.canAnswer("Ъ���� ������� ����һ����:"));
      assertEquals(3, answerer.answer("Ъ���� ������� ����һ����:", new String[] { "����", "һĿ��Ȼ", "�ٷ�����", "Ψ���Ǿ�" }));
   }
}
