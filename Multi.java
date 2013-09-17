public class Multi {

	public static void main(String[] args) {
		int[][] a = { {1, 2, 3, 4, 5}, 
				    {6, 7, 8, 9, 10},
				    {11, 12, 13, 14, 15}  };

		sumCol(a);    

	}

	public void print(int[][] a) {
		for (int r=0; r < a.length; r++) {
			for (int c=0; c < a[r].length; c++) {
				
				System.out.println(a[r][c] + " ");

			}

			System.out.println();

		}


	}

	public static int sumRow(int[][] a) {
		
		int sum = 0;
		int f = 1;

		for (int r=0; r <a.length; r++) {
			sum = 0;

			for (int c=0; c < a[r].length; c++) {


				sum = sum + a[r][c];
			}


			System.out.println("row " + f + " = " + sum);
			f++;


		}

		return sum;
	}

	public static int sumCol(int[][] a) {
		
		int sum = 0;
		int f = 1;
		int r=0;

		for (int c=0; c <a[r].length; c++) {
			sum = 0;

			for (r=0; r < a.length; r++) {


				sum = sum + a[r][c];
			}


			System.out.println("Column " + f + " = " + sum);
			f++;

			r=0;
		}

		return sum;
	}




}