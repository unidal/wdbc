package org.unidal.wdbc.query;

import java.util.Map;

import org.codehaus.plexus.configuration.PlexusConfiguration;

import org.unidal.wdbc.query.path.WdbcPathPattern;
import org.unidal.wdbc.query.path.WdbcTagTree;
import org.unidal.wdbc.query.path.WdbcWordPattern;

public interface WdbcContext {
   public void endAllChildren();

   public void endAllText();

   public PlexusConfiguration getAllChildren();

   public String getAllText();

   public String getAttribute(String name);

   public Map<String, String> getAttributes();

   public String getComment();

   public String getTagName();

   public String getText();

   public String getTrailPath(WdbcWordPattern pattern);

   public int matchesPath(WdbcPathPattern pattern);

   public int matchesPath(WdbcPathPattern pattern, Map<String, String> attributes);

   public void pop(String tagName);

   public void push(String tagName, Map<String, String> attributes);

   public void setComment(String comment);

   public void setTagTree(WdbcTagTree tagTree);

   public void setText(String text);

   public void startAllChildren();

   public void startAllText();
}
