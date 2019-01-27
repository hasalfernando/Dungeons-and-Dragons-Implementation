import java.util.Scanner;

public class AssesmentOne {

	public static void main(String[] args) {
		// Define and initialize variables and objects
		int str = 0;
		int dex = 0;
		int con = 0;
		int Int = 0;
		int wis = 0;
		int cha = 0;
		int level = 0;
		int bonus = 0;
		int hitPoints = 0;
		int i = 0;
		Scanner scan0 = new Scanner(System.in);

		// Ask for level
		System.out.println("level ?");

		// Take the input for level
		if (scan0.hasNextInt()) {
			level = scan0.nextInt();
			// Reject the input and terminate the program if the input is less than or equal
			// to 0
			if (level <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}
		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Ask for str
		System.out.println("str ?");
		// Take the input for str
		if (scan0.hasNextInt()) {
			str = scan0.nextInt();
			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (str <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}
		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Ask for dex
		System.out.println("dex ?");

		// Take the input for dex
		if (scan0.hasNextInt()) {
			dex = scan0.nextInt();
			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (dex <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}
		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}
		// Ask for con
		System.out.println("con ?");

		// Take input for con
		if (scan0.hasNextInt()) {
			con = scan0.nextInt();

			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (con <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}
		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Ask for Int
		System.out.println("Int ?");

		// Take input for Int
		if (scan0.hasNextInt()) {
			Int = scan0.nextInt();

			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (Int <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}

		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Ask for wis
		System.out.println("wis ?");

		// Take input for wis
		if (scan0.hasNextInt()) {
			wis = scan0.nextInt();

			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (wis <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}
		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Ask for cha
		System.out.println("cha ?");

		// Take input for cha
		if (scan0.hasNextInt()) {
			cha = scan0.nextInt();

			// Reject the input and terminate the program if the input is less than or equal
			// 0
			if (cha <= 0) {
				System.err.println("Only positive integer values are accepted.");
				System.exit(0);
			}
		}

		// Reject the input and terminate the program if the input is not an integer
		// value
		else {
			System.err.println("Only positive integer values are accepted.");
			System.exit(0);
		}

		// Print level
		System.out.println("level : " + level);

		// If str is an even number above 10, cumulative +1 for each even number above 10
		if (str > 10) {
			if (str % 2 == 0) {
				i = (str - 10) / 2;
			}
			// If str is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (str - 11) / 2;
			}
			bonus = bonus + i;
		}

		else {
			// If str is an odd number below 10, bonus = bonus - 1
			if (str % 2 == 1) {
				i = (11 - str) / 2;
			}
			// If str is an even number below 10, add the cumulative value of the odd numbers upto it.
			else {
				i = (10 - str) / 2;
			}
			bonus = bonus - i;
		}
		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("str: " + str + " " + bonus);
		}

		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("str: %d %+d\n", str, bonus);
		}

		bonus = 0;
		i = 0;

		// If dex is an even number above 10
		if (dex > 10) {
			if (dex % 2 == 0) {
				i = (dex - 10) / 2;
			}
			// If dex is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (dex - 11) / 2;
			}
			bonus = bonus + i;
		} else {
			// If dex is an odd number below 10
			if (dex % 2 == 1) {
				i = (11 - dex) / 2;
			}
			// If dex is an even number below 10, add the cumulative value of the even numbers upto it.
			else {
				i = (10 - dex) / 2;
			}
			bonus = bonus - i;
		}
		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("dex: " + dex + " " + bonus);
		}

		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("dex: %d %+d\n", dex, bonus);
		}

		bonus = 0;
		i = 0;

		// If con is an even number above 10
		if (con > 10) {
			if (con % 2 == 0) {
				i = (con - 10) / 2;
			}

			// If con is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (con - 11) / 2;
			}
			bonus = bonus + i;
		} else {
			// If con is an odd number below 10
			if (con % 2 == 1) {
				i = (11 - con) / 2;
			}

			// If con is an even number below 10, add the cumulative value of the even numbers upto it.
			else {
				i = (10 - con) / 2;
			}
			bonus = bonus - i;
		}
		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("con: " + con + " " + bonus);
		}
		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("con: %d %+d\n", con, bonus);
		}
		bonus = 0;
		i = 0;

		// If Int is an even number above 10
		if (Int > 10) {
			if (Int % 2 == 0) {
				i = (Int - 10) / 2;
			}
			// If Int is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (Int - 11) / 2;
			}
			bonus = bonus + i;
		} else {
			// If Int is an odd number below 10
			if (Int % 2 == 1) {
				i = (11 - Int) / 2;
			}

			// If Int is an even number below 10, add the cumulative value of the even numbers upto it.
			else {
				i = (10 - Int) / 2;
			}
			bonus = bonus - i;
		}

		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("Int: " + Int + " " + bonus);
		}
		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("Int: %d %+d\n", Int, bonus);
		}
		bonus = 0;
		i = 0;

		// If wis is an even number above 10

		if (wis > 10) {
			if (wis % 2 == 0) {
				i = (wis - 10) / 2;
			}
			// If wis is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (wis - 11) / 2;
			}
			bonus = bonus + i;
		} else {
			// If wis is an odd number below 10
			if (wis % 2 == 1) {
				i = (11 - wis) / 2;
			}

			// If wis is an even number below 10, add the cumulative value of the even numbers upto it.
			else {
				i = (10 - wis) / 2;
			}
			bonus = bonus - i;
		}

		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("wis: " + wis + " " + bonus);
		}
		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("wis: %d %+d\n", wis, bonus);
		}
		bonus = 0;
		i = 0;

		// If cha is an even number above 10
		if (cha > 10) {
			if (cha % 2 == 0) {
				i = (cha - 10) / 2;
			}
			// If cha is an odd number above 10, add the cumulative value of the even numbers upto it.
			else {
				i = (cha - 11) / 2;
			}
			bonus = bonus + i;
		} else {
			// If cha is an odd number below 10
			if (cha % 2 == 1) {
				i = (11 - cha) / 2;
			}

			// If cha is an even number below 10, add the cumulative value of the even numbers upto it.
			else {
				i = (10 - cha) / 2;
			}
			bonus = bonus - i;
		}

		// No sign if the bonus is 0
		if (bonus == 0) {
			System.out.println("cha: " + cha + " " + bonus);
		}
		// Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("cha: %d %+d\n", cha, bonus);
		}

		// Calculate and print hitPoints
		hitPoints = (int) (level * (Math.random() * 1000 % 6 + 1));
		System.out.println("HP: " + hitPoints);
		// Close the Scanner object.
		scan0.close();

	}
}
