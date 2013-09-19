public class Multi {

	public static void main(String[] args) {
		int[][] a = { {1, 2, 3, 4, 5}, 
				    {6, 7, 8, 9, 10},
				    {11, 12, 13, 14, 15}  };

		// snakeDraft(10,3);
		// print(a);   
		int[] b = {1, 2, 3, 4, 5, 6};
		print(rectangularize(b, 3, 2));

	}

	public static void print(int[][] a) {
		for (int r=0; r < a.length; r++) {
			for (int c=0; c < a[r].length; c++) {
				
				System.out.println(a[r][c] + " ");

			}

			System.out.println();

		}


	}

	// public static int sumRow(int[][] a) {
		
	// 	int sum = 0;
	// 	int f = 1;

	// 	for (int r=0; r <a.length; r++) {
	// 		sum = 0;

	// 		for (int c=0; c < a[r].length; c++) {


	// 			sum = sum + a[r][c];
	// 		}


	// 		System.out.println("row " + f + " = " + sum);
	// 		f++;


	// 	}

	// 	return sum;
	// }

	// public static int sumCol(int[][] a) {
		
	// 	int sum = 0;
	// 	int f = 1;
	// 	int r=0;

	// 	for (int c=0; c <a[r].length; c++) {
	// 		sum = 0;

	// 		for (r=0; r < a.length; r++) {


	// 			sum = sum + a[r][c];
	// 		}


	// 		System.out.println("Column " + f + " = " + sum);
	// 		f++;

	// 		r=0;
	// 	}

	// 	return sum;
	// }

	// public static int sumTotal(int[][] a) {

	// 	int sum = 0;
	// 	int total = 0;

	// 	for (int r=0; r <a.length; r++) {
	// 		sum = 0;

	// 		for (int c=0; c < a[r].length; c++) {


	// 			sum = sum + a[r][c];
	// 		}


	// 		total = total + sum;
	// 	}

		
	// 	System.out.println("The total value is: "+total);

	// 	return total;
	// }

	// public static int[][] reverseRow(int[][] a) {

	// 	int sum = 0;
	// 	int f = 1;

	// 	for (int r=0; r <a.length; r++) {
	// 		sum = 0;

	// 		for (int c=0; c < a[r].length; c++) {


	// 			sum = sum + a[r][c];
	// 		}


	// 		System.out.println("row " + f + " = " + sum);
	// 		f++;


	// 	}

	// 	return a;

	// }


	// public static int[][] snakeDraft(int players, int rounds) {

	// 	int[][] a = new int[players][rounds];
		
	// 	for (int r=0; r<rounds; r++) {
	// 		for (int c=0; c<players; c++) {
	// 			int count=1 + (r*10);
	// 			a[r][c] = count;
	// 			count ++;
	// 		}


	// 	}

	// 	return a;

	//}


	public static int[][] rectangularize(int[] a, int rows, int cols) {
		int[][] result = new int[rows][cols];

		int counter = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				result[i][j] = a[counter];
				counter++;
			}


		}
		return result; 
	}




}