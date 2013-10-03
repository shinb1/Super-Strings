import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.*;

public class Tester {

	private static int testCount, passes, failures;

	private static int ecNum, ecGoal, ecPoints, ecPointsEarned;
	private static boolean awardEC = false;

	protected void failure(String message) {
		System.out.println(testCount + ": " + message + " : Failed");
		failures++;
		testCount++;
	}

	protected void success(String message) {
		System.out.println(testCount + ": " + message + " : Passed");
		passes++;
		testCount++;
	}

	protected void ecSuccess(String message) {
		System.out.println(ecNum + ": " + message + " : Passed");
		ecNum++;
	}

	protected void ecFailure(String message) {
		System.out.println(ecNum + ": " + message + " : Failed");
		ecNum++;
		awardEC = false;
		ecPoints = 0;
	}

	protected void check(boolean test, String message) {
		if (test) {
			success(message);
		} else {
			failure(message);
		}
		
		// assertTrue(test);
	}

	protected void ecCheck(boolean test, String message) {
		if (test) {
			ecSuccess(message);
		} else {
			ecFailure(message);
		}
	}

	protected void checkNotNull(Object o, String message) {
		if (o != null) {
			success(message);
		} else {
			failure(message);
		}

		// assertNotNull(o);
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@AfterClass
    public static void tearDownClass() throws Exception {
    	if (awardEC) {
    		ecPointsEarned = ecPoints;
    	}

    	System.out.println("\n\nResults");
    	System.out.println("-------");

    	System.out.println("Passes: " + passes);
    	System.out.println("Failures: " + failures);
    	System.out.println("Tests: " + testCount);
    	
    	System.out.println("\n\nScore - Out of 25\n----------------- ");

    	double score = 25;
    	if (failures > 0) {
    		score = (((double) passes) / testCount) * 25;
    	}

    	long s = Math.round(score);
    	System.out.println(s);

    	System.out.println();
    	if (ecPointsEarned > 0) {
    		System.out.println("Extra Credit: " + ecPointsEarned);
    		s += ecPoints;
    		System.out.println("\nFinal Score\n----------- ");
    		System.out.println(s);
    	} else {
    		System.out.println("\nNo Extra Credit Earned\n");
    	}
    }

    protected void printDashes(String name) {
    	String dashes = "";
    	for (int i=0;i<name.length();i++) {
    		dashes += "-";
    	}
    	System.out.println(dashes);
    }

    private void printBanner(String methodName, int methodNumber) {
    	// System.out.println("\n" + methodNumber + ") " + methodName);
    	printDashes(methodName);
    }

    public static boolean close(double a, double b) {
    	return Math.abs(a-b) < 0.25;
    }

    private void runTestsOn(String methodName, int methodNumber, Class[] argList, ArrayList<MethodTest> tests, boolean privated, boolean checkForPrivate) {

    	printBanner(methodName, methodNumber);

    	try {
    		Class<?> c = Bingo.class;
    		Method method;
    		if (!privated) {
    			method = c.getMethod(methodName, argList);
    		} else {
    			method = c.getDeclaredMethod(methodName, argList);
    			method.setAccessible(true);
    		}

    		// success("was attempted");

    		if (privated && checkForPrivate) {
    			try {
    				c.getMethod(methodName, argList);
    				failure("should be private");
    			} catch (NoSuchMethodException e) {
    				success("should be private");
    			}
    		}

	    	for (MethodTest test : tests) {
	    		test.method = method;
	    		final MethodTest theTest = test;
				ExecutorService executor = Executors.newSingleThreadExecutor();
				Future<String> future = executor.submit(new Task() {
					public String call() throws Exception {
				    	try {
				    		theTest.run();
				    	} catch (IllegalAccessException e) {
				    		fail(e.getMessage());
				    	} catch (Exception e) {
				    		System.out.println(e.getMessage());
				    		failure("crashed while attempting: " + theTest.message);
				    	}    

				        return "Done";
				    }
				});
				try {
		            future.get(1, TimeUnit.SECONDS);
		        } catch (TimeoutException e) {
		            failure("infinite loop while attempting: " + test.message);
		        } catch (Exception e) {
		        	failure("infinite loop while attempting: " + test.message);
		        }
		        executor.shutdownNow();
	    	}	

    	} catch (NoSuchMethodException e) {
    		failure("was attempted");
    		for (MethodTest test : tests) {
    			failure(test.message);
    		}
    	}
    }


    protected void runTestsForMethod(String methodName, int methodNumber, Class[] argList, ArrayList<MethodTest> tests) {

    	runTestsOn(methodName, methodNumber, argList, tests, false, false);
    }

    protected void runTestsForPrivateMethod(String methodName, int methodNumber, Class[] argList, ArrayList<MethodTest> tests, boolean checkForPrivate) {

    	runTestsOn(methodName, methodNumber, argList, tests, true, checkForPrivate);	
    }

    protected void runTestsForExtraCreditMethod(String methodName, int methodNumber, Class[] argList, ArrayList<MethodTest> tests, int points) {

    	ecNum = 0;
    	ecGoal = tests.size();
    	if (awardEC) {
    		ecPointsEarned = ecPoints;
    	}
    	ecPoints = points;
    	awardEC = true;

    	runTestsOn(methodName, methodNumber, argList, tests, false, false);
    }
}

// used as an anonymous inner class
// holds an individual test for a method
// run method is defined when created so it can do arbitrary tests
abstract class MethodTest {
	public String message;
	public Method method;

	public abstract void run() throws Exception;

	public MethodTest message(String message){
	    this.message = message;
	    return this;
	}
	
}

// for running the infinite loop check
abstract class Task implements Callable<String> {
    
}