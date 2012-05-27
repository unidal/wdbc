package org.unidal.wdbc.jctrans;

import java.io.File;

import org.unidal.wdbc.ant.AbstractConfiguration;

public class Configuration extends AbstractConfiguration {
   public Configuration() {
      super("wdbc-jctrans");
   }

   @Property(name = "dataDir", desc = "Where will the data be stored?")
   public String getDataDir() {
      return getParameterValue("dataDir", "target");
   }

   public static void main(String[] args) {
      generateScriptFile(new Configuration(), new File("src/main/scripts/robot.sh"), true);
      generateScriptFile(new Configuration(), new File("src/main/scripts/robot.bat"), false);
   }
}