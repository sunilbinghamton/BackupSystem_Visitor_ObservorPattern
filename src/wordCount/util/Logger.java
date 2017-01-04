package wordCount.util;

/**
 * @author Sunil
 *
 */
public class Logger{


    public static enum DebugLevel { 
    		AVG, STORE, RESULT, THREAD, CONSTRUCTOR    };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
		case 0: debugLevel = DebugLevel.AVG; break;
		case 1: debugLevel = DebugLevel.STORE; break;
		case 2: debugLevel = DebugLevel.RESULT; break;
		case 3: debugLevel = DebugLevel.THREAD; break;
		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  }
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}

