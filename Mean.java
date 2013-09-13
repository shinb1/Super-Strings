import java.util.Reader;

public class Mean {
	private static Random r = new Random(5345);

	public static void main(String[] args) {
		int[] randomArray = makeRandom(100, 100);
		System.out.println("The average of the array is ");
		System.out.println(mean(randomArray) + ".");

		System.out.println("The average from index 40 to index 45 is ");
		System.out.println(meanOfRange(randomArray, 40, 45) + ".");
	}

	public static double mean(int[] a) {



	}

	public static double meanOfRange(int[] a, int start, int end) {
		double total = 0.0;
		for (int i = start; i<= end; i++) {
			
		}

	}

	public static int[] makeRandom(int size, int range) {
		int[] a = new int[size];

		for (int i=0; i<a.length; i++) {
			a[i] = r.nextInt(range + 1);
		}

		return a;

	}


}