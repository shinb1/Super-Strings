import java.util.Scanner;
import java.util.Random;

public class CSV {
	
	
	public static void main(String[] args) {

		String[] names = {"Steven","Ben","Jack","David","Michael","Jason"};

		printArray(names);
		choose(names);
		
	}

	public static void printArray(String[] a) {
		
		for (int i=0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}

		System.out.println();
	}

	public static void choose(String[] a) {

		Scanner reader = new Scanner(System.in);
		Random random = new Random();

		String name;
		int amount;
		
		System.out.println("How many people would you like to choose?");
		amount = reader.nextInt();

		for (int i=0; i<amount; i++) {
			name = a[random.nextInt(a.length)];
			System.out.println(name);
		}

	}
	


	
}