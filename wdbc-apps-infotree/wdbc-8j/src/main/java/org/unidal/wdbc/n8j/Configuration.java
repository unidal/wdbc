package org.unidal.wdbc.n8j;

import java.io.File;

import org.unidal.wdbc.infotree.AbstractConfiguration;

public class Configuration extends AbstractConfiguration {
   public Configuration() {
      super("wdbc-8j");
   }

   public static void main(String[] args) {
      generateScriptFile(new Configuration(), new File("src/main/scripts/robot.sh"), true);
      generateScriptFile(new Configuration(), new File("src/main/scripts/robot.bat"), false);
   }
}
