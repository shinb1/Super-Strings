public class Strings {

	public static void main(String[] args) {
		String str = new String("A string");
		String s = "abcdefghijklmnopqrstuvwxyz";

		System.out.println(isCaptainCrunch(s));


		// if (str.equals(s)) {
		// 	System.out.println("A");
		// } else {
		// 	System.out.println("B");
		// }


		// for (int i=0; i < str.length(); i++) {
		// 	System.out.println(str.charAt(i));
			
		// }

		// for (int i=0; i < str.length()-1; i++) { 
		// 	System.out.println(str.substring(i, i + 2));
		// }

		// if (contains("baseball", "ball")) {
		// 	System.out.println("Yes");

		// } else {
		// 	System.out.println("No");
		// }

		// System.out.println(count("people", "e"));
		// 
		// isPalindrom("racecar");

	}

		public static int count(String s, String t) {
			int total = 0;

			for (int i=0; i <s.length(); i++) {	
				if (s.charAt(i)==(t.charAt(0))) {
					total ++;
				}
			}

			return total;

		}

		public static boolean contains(String s, String t) {
			for (int i=0; i < s.length()-t.length(); i++) {
				if (s.substring(i, i+t.length()).equals(t)) {
					return true;
				}
			}

			return false;

		}
		
		public static boolean isPalindrom(String s) {
			for (int i=0; i < s.length(); i++) {
				if (s.charAt(i)==s.charAt(s.length()-i)) {
					return true;
				}
			}

			return false;

		}

		public static boolean isAbecedarian(String s) {
			for (int i=0; i < s.length()-1; i++) {
				if (s.charAt(i)>s.charAt(i+1)) {
					return false;
				}
			}

			return true;
		}

		public static boolean isDupledrome(String s) {
			for (int i=0; i < s.length()-1; i+=2) {
				if (s.charAt(i)!=s.charAt(i+1)) {
					return false;
				}
			}

			return true;
		}

		public static String isCaptainCrunch(String s) {

			for (int i=0; i < s.length(); i++) {
				
				s.charAt(i) = s.charAt(i) + 13;


			}

			return s;
		}

		

}