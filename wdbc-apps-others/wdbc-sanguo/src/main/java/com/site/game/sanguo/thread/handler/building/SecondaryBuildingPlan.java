package com.site.game.sanguo.thread.handler.building;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

public class SecondaryBuildingPlan extends AbstractBuildingPlan implements Initializable {
   public void initialize() throws InitializationException {
      build("����", 8);
      build("�ֿ�", 8);
      build("�о���", 5);
      build("��Ժ", 10);
      build("����", 20);
      build("�ֿ�", 20);
      build("����", 3);
      build("У��", 5);
      build("��ľ˾", 10);
      build("����", 10);
      build("У��", 10);
      build("ѧ��", 10);
      build("��ľ˾", 20);
      build("����", 10);
      build("����", 20);
      build("����", 20);
      build("�ֿ�", 20);
   }
}
