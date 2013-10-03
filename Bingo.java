public class Bingo {

	public static void main(String[] args) {
		
		int[][] board = { 	{ 1,  2,  3,  4,  5},
							{ 6,  7,  8,  9, 10}, 
							{11, 12, 13, 14, 15},
							{16, 17, 18, 19, 20},
							{21, 22, 23, 24, 25}	};;

		int[] drawn = {3, 7, 11, 17, 23, 19, 15, 9};



		print(correct(board, drawn));
		
		if (rowBingo(board) == true || colBingo(board) == true) {
			System.out.println("true");;
		}


	}

	public static void print(int[][] a) {
		for (int r=0; r<a.length; r++ ) {
			for (int c=0; c<a[r].length ; c++ ) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean bingo(int[][] board, int[] drawn) {

		print(board);

		if (rowBingo(board) == true || colBingo(board) == true) {
			return true;
		}

		return false;
	}

	public static int[][] correct(int[][] board, int[] drawn) {

		int [][] newBoard = new int[board.length][board.length];

		for (int row = 0; row < board.length; row++) {
			
			for (int col=0; col<board.length; col++) {
				
				for (int i=0; i<drawn.length; i++) {
					if (drawn[i] == board[row][col]) {
						board[row][col] = 0;
					}
				}

			}

		}

		return newBoard;

	}

	public static boolean rowBingo(int[][] board) {

		int count = 0;

		for (int row=0; row<board.length; row++) {
			count = 0;
			for (int col = 0; col<board.length; col++) {
				count = count + board[row][col];
			}
			if (count == 0) {
				return true;
			}

		}

		return false;

	}

	public static boolean colBingo(int[][] board) {

		int count = 0;

			for (int row=0; row<board.length; row++) {
				count = 0;
				for (int col = 0; col<board.length; col++) {
					count = count + board[col][row];
				}
				if (count == 0) {
					return true;
				}

			}

			return false;

	}

}