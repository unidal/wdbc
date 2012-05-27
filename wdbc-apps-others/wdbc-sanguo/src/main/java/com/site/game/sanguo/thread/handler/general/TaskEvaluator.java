package com.site.game.sanguo.thread.handler.general;

public class TaskEvaluator {
   public boolean evaluate(General general, com.site.game.sanguo.model.StateTask task) {
      if (task.getTypeName().equals("����") && general.getWuli() <= 30) {
         return false;
      } else if (task.getTypeName().equals("Χ��") && general.getTongyuli() <= 30) {
         return false;
      } else if (task.getTypeName().equals("˵��") && general.getZhenzhili() <= 30) {
         return false;
      } else if (task.getTypeName().equals("����") && general.getZhili() <= 30) {
         return false;
      } else {
         double difficult = Math.sqrt(task.getPoints()); // [1, 10]
         double health = general.getTili(); // [1, 100]

         return health >= 20 + difficult * 16;
      }
   }
}
