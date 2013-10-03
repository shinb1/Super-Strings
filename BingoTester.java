import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.*;

public class BingoTester extends Tester {

	@Test 
	public void m00_bingo() {
		System.out.println("Horizontal Bingos");
		String methodName = "bingo";
		int methodNumber = 0;
		Class[] methodArgs = new Class[]{int[][].class, int[].class};

		ArrayList<MethodTest> tests = new ArrayList<MethodTest>();
		

		final int[][] board = { 	{1, 2, 3},
									{4, 5, 6}, 
									{7, 8, 9}	};

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 2, 3};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a row 1 bingo"));
		
		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {4, 5, 6};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a row 2 bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 8, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a row 3 bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {4, 1, 2};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 5, 1};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find another bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 2};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find a third bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {9, 8, 7};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("the order of drawn numbers should not matter"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {4, 6};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a middle row bingo including the free space"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 8, 10, 2, 4, 3};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a bingo with extra drawn numbers"));

		runTestsForMethod(methodName, methodNumber, methodArgs, tests);
	}


	@Test 
	public void m01_bingo() {
	System.out.println("Vertical Bingos");
		String methodName = "bingo";
		int methodNumber = 0;
		Class[] methodArgs = new Class[]{int[][].class, int[].class};

		ArrayList<MethodTest> tests = new ArrayList<MethodTest>();
		

		final int[][] board = { 	{1, 2, 3},
									{4, 5, 6}, 
									{7, 8, 9}	};

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 4, 7};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a column 1 bingo"));
		
		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {2, 5, 8};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a column 2 bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {3, 6, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a column 3 bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {6, 8, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 5, 6};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find another bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 2, 7, 6};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(!isABingo, message);
			}
		}.message("should fail to find a third bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 1, 4};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("the order of drawn numbers should not matter"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {2, 8};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				check(isABingo, message);
			}
		}.message("should find a middle column bingo including the free space"));

		runTestsForMethod(methodName, methodNumber, methodArgs, tests);
	}

	@Test 
	public void m02_bingo() {
	System.out.println("Four Corner Bingos - 1 Extra Credit Pt If Tests All Pass");
		String methodName = "bingo";
		int methodNumber = 0;
		Class[] methodArgs = new Class[]{int[][].class, int[].class};

		ArrayList<MethodTest> tests = new ArrayList<MethodTest>();
		

		final int[][] board = { 	{1, 2, 3},
									{4, 5, 6}, 
									{7, 8, 9}	};

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 3, 7, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should find a four corner bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 2, 6};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {9, 3, 1, 7};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("the order of drawn numbers should not matter"));

		runTestsForExtraCreditMethod(methodName, methodNumber, methodArgs, tests, 1);
	}

	@Test 
	public void m03_bingo() {
	System.out.println("Diagonal Bingos - 2 Extra Credit Pts If Tests All Pass");
		String methodName = "bingo";
		int methodNumber = 0;
		Class[] methodArgs = new Class[]{int[][].class, int[].class};

		ArrayList<MethodTest> tests = new ArrayList<MethodTest>();
		

		final int[][] board = { 	{1, 2, 3},
									{4, 5, 6}, 
									{7, 8, 9}	};

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {1, 5, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should find a backslash bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {7, 5, 3};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should find a frontslash bingo"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {2, 4, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {3, 7, 5};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("the order of drawn numbers should not matter"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {3, 7};
				boolean isABingo = ((Boolean)method.invoke(null, board, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should ignore the free space"));

		runTestsForExtraCreditMethod(methodName, methodNumber, methodArgs, tests, 2);
	}

	@Test 
	public void m04_bingo() {
	System.out.println("Diamond Bingos - 3 Extra Credit Pts If Tests All Pass");
		String methodName = "bingo";
		int methodNumber = 0;
		Class[] methodArgs = new Class[]{int[][].class, int[].class};

		ArrayList<MethodTest> tests = new ArrayList<MethodTest>();
		

		final int[][] board2 = { 	{ 1,  2,  3,  4,  5},
									{ 6,  7,  8,  9, 10}, 
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20},
									{21, 22, 23, 24, 25}	};
		
		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {3, 7, 11, 17, 23, 19, 15, 9};
				boolean isABingo = ((Boolean)method.invoke(null, board2, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should find a diamond bingo on a 5x5 board"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {2, 8, 12, 6, 4, 10, 14, 25};
				boolean isABingo = ((Boolean)method.invoke(null, board2, drawn)).booleanValue();
				ecCheck(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist on a 5x5 board"));

		final int[][] board3 = new int[7][7];

		int count = 1;
		for (int i=0;i<board3.length; i++) {
			for (int j=0; j<board3.length; j++) {
				board3[i][j] = count;
				count++;
			}
			
		}
		
		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {4, 10, 12, 16, 20, 22, 28, 30, 34, 38, 40, 46};
				boolean isABingo = ((Boolean)method.invoke(null, board3, drawn)).booleanValue();
				ecCheck(isABingo, message);
			}
		}.message("should find a diamond bingo on a 7x7 board"));

		tests.add(new MethodTest() {
			public void run() throws Exception{
				int[] drawn = {4, 10, 12, 16, 20, 22, 28, 30, 34, 38, 40, 45};
				boolean isABingo = ((Boolean)method.invoke(null, board3, drawn)).booleanValue();
				ecCheck(!isABingo, message);
			}
		}.message("should fail to find a bingo that does not exist on a 7x7 board"));


		runTestsForExtraCreditMethod(methodName, methodNumber, methodArgs, tests, 3);
	}


}