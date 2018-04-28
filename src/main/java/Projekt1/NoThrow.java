package Projekt1;

class NoThrow{
  public static void assertDoesNotThrow(FailingRunnable action){
    try{
      action.run();
    }
    catch(Exception ex){
      throw new Error("NO THROWWW", ex);
    }
  }
}

@FunctionalInterface interface FailingRunnable { void run() throws Exception; }