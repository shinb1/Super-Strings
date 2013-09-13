public class Arrays {

	public static void main(String[] args) {
		int[] data = new int[10];
		int j = 5;
		
		for (int i=0; i < data.length; i++,j++) {
			data[i] = j;			
		}

		twoLargest(data);

		printArray(data);


		// for (int i=0; i < data.length; i++) {
		// 	System.out.println(data[i] + " ");
		// }

		// countdown array
		
	}

	// public static int[] doublet(int[] a) {
		
	// 	for (int i=0; i < a.length; i++) {
	// 		a[i] = a[i] + 2;

	// 	}

	// }




	public static void printArray(int[] a) {
		
		for (int i=0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}

		System.out.println();
	}

	public static void twoLargest(int[] a) {
		int[] data = new int[10];

		int j = 5;
		
		for (int i=0; i < data.length; i++,j++) {
			data[i] = j;			
		}


		int x = a[0];
		int y = a[1];

		for (int i=2; i < data.length; i++) {
			
			if (y>x) {
				if (data[i]>x) {
					x = data[i];
				} else if (data[i]>y) {
					y = data[i];
				}
			} else {
				if (data[i]>y) {
					y = data[i];
				} else if (data[i]>x) {
					x = data[i];
				}
			}	
		}


		System.out.println("The largest number is " + x);
		System.out.println("The second largest is " + y);
		System.out.println();
	}


}