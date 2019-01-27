import java.io.IOException;
import java.util.Scanner;

public class AssesmentTwo{
	public static void main (String [] args)throws IOException, InterruptedException {
		//Declare & Initialize variables
		int str = 0;
		int dex = 0;
		int con = 0;
		int Int = 0;
		int wis = 0;
		int cha = 0;
		int level = 0;
		int bonusStr = 0;
		int bonusDex = 0;
		int bonusCon = 0;
		int bonusInt = 0;
		int bonusWis = 0;
		int bonusCha = 0;
		int hitPoints = 0;
		int str1 = 0;
		int dex1 = 0;
		int con1 = 0;
		int int1 = 0;
		int wis1 = 0;
		int cha1 = 0;
		int i = 0; 
		boolean roll = true;
		String userChoice = new String();
		Scanner scan0 = new Scanner(System.in);

		//Ask for level
		System.out.println("level ?");
		
		//Take the input for level
		if (scan0.hasNextInt()) {
			level = scan0.nextInt();
			if(level<=0) //Reject the input and terminate the program if the input is less than or equal 0 
			{
				System.err.println("Please enter a positive integer.");
				System.exit(0);
			}
		}  	  
		else { //Reject the input and terminate the program if the input is not an integer value
			System.err.println("Please enter a positive integer.");
			System.exit(0);
		}

		do { //while user rejects the generated output
			str = 0;
			dex = 0;
			con = 0;
			Int = 0;
			wis = 0;
			cha = 0;
			bonusStr = 0;
			bonusDex = 0;
			bonusCon = 0;
			bonusInt = 0;
			bonusWis = 0;
			bonusCha = 0;
			hitPoints = 0;
			//Generate 3 Random numbers for each input and assign the sum of those three numbers for the input		
			for(i=0; i<3; i++) {
				str1 =(int)(Math.random()*1000 %6+1);	
				str = str + str1;
			}	
			for(i=0; i<3; i++) {
				dex1 =(int)(Math.random()*1000 %6+1);	
				dex = dex + dex1;
			}
			for(i=0; i<3; i++) {
				con1 =(int)(Math.random()*1000 %6+1);	
				con = con + con1;
			}
			for(i=0; i<3; i++) {
				int1 =(int)(Math.random()*1000 %6+1);	
				Int = Int + int1;
			}
			for(i=0; i<3; i++) {
				wis1 =(int)(Math.random()*1000 %6+1);	
				wis = wis + wis1;
			}
			for(i=0; i<3; i++) {
				cha1 =(int)(Math.random()*1000 %6+1);	
				cha = cha + cha1;
			}

			//Print level 
			System.out.println("level : "+level);
			
			//If str is an even number above 10, cumulative +1 for each even number above 10
			if (str > 10){
				if (str % 2 == 0){
					i = (str - 10)/2;
				}
				//If str is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {
					i = (str - 11)/2;
				}
				bonusStr = bonusStr + i;
			}
			else {
				//If str is an odd number below 10, Bonus = Bonus - 1
				if (str < 10){
					if (str % 2 == 1){
						i = (11-str)/2;
					}
					//If str is an even number below 10, add the cumulative value of the odd numbers upto it.
					else {
						i = (10-str)/2;
					}
					bonusStr = bonusStr - i;
				}
			}		
			//No sign if the Bonus is 0	
			if (bonusStr == 0) {
				System.out.println("str: " + str + " " + bonusStr);
			}
			//Put the sign if it is a positive or a negative integer
			else {
				System.out.printf("str: %d %+d\n", str, bonusStr);
			}
				
			i = 0;
			//If dex is an even number above 10
			if (dex > 10){
				if (dex % 2 == 0){
					i = (dex - 10)/2;
				}
				//If dex is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {	
					i = (dex - 11)/2;
				}
				bonusDex = bonusDex + i;
			}
			else {
				//If dex is an odd number below 10
				if (dex < 10){
					if (dex % 2 == 1){
						i = (11-dex)/2;
					}
					//If dex is an even number below 10, add the cumulative value of the even numbers upto it.
					else {
						i = (10-dex)/2;
					}
					bonusDex = bonusDex - i;
				}
			}		
			//No sign if the Bonus is 0
			if (bonusDex == 0) {
				System.out.println("dex: " + dex + " " + bonusDex);
			}
			//Put the sign if it is a positive or a negative integer
			else {
				System.out.printf("dex: %d %+d\n", dex, bonusDex);
			}
		
			i = 0;
			//If con is an even number above 10
			if (con > 10){
				if (con % 2 == 0){
					i = (con - 10)/2;
				}
				//If con is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {
					i = (con - 11)/2;
				}
				bonusCon = bonusCon + i;
			}
			else {
				//If con is an odd number below 10
				if (con < 10){
					if (con % 2 == 1){
						i = (11-con)/2;
					}
					//If con is an even number below 10, add the cumulative value of the even numbers upto it.
					else {
						i = (10-con)/2;
					}
					bonusCon = bonusCon - i;
				}
			}	

			//No sign if the Bonus is 0
			if (bonusCon == 0) {
				System.out.println("con: " + con + " " + bonusCon);
			}
			//Put the sign if it is a positive or a negative integer
			else {
				System.out.printf("con: %d %+d\n", con, bonusCon);
			}

			i = 0;
			//If Int is an even number above 10
			if (Int > 10){
				if (Int % 2 == 0){
					i = (Int - 10)/2;
				}
				//If Int is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {
					i = (Int - 11)/2;
				}
				bonusInt = bonusInt + i;
			}
			else {
				//If Int is an odd number below 10
				if (Int < 10){
					if (Int % 2 == 1){
						i = (11-Int)/2;
					}
					//If Int is an even number below 10, add the cumulative value of the even numbers upto it.
					else {
						i = (10-Int)/2;
					}
					bonusInt = bonusInt - i;
				}
			}	
			//No sign if the Bonus is 0
			if (bonusInt == 0) {
				System.out.println("Int: " + Int + " " + bonusInt);
			}
			//Put the sign if it is a positive or a negative integer	
			else {
				System.out.printf("Int: %d %+d\n", Int, bonusInt);
			}

			i = 0;
			//If wis is an even number above 10
			if (wis > 10){
				if (wis % 2 == 0){
					i = (wis - 10)/2;
				}	
				//If wis is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {
					i = (wis - 11)/2;
				}
				bonusWis = bonusWis + i;
			}
			else {
				//If wis is an odd number below 10
				if (wis < 10){
					if (wis % 2 == 1){
						i = (11-wis)/2;
					}
					//If wis is an even number below 10, add the cumulative value of the even numbers upto it.
					else {
						i = (10-wis)/2;
					}
					bonusWis = bonusWis - i;
				}
			}	
					
			//No sign if the Bonus is 0
			if (bonusWis == 0) {
				System.out.println("wis: " + wis + " " + bonusWis);
			}
			//Put the sign if it is a positive or a negative integer
			else {
				System.out.printf("wis: %d %+d\n", wis, bonusWis);
			}

			i = 0;
			//If cha is an even number above 10	
			if (cha > 10){
				if (cha % 2 == 0){
					i = (cha - 10)/2;
				}
				//If cha is an odd number above 10, add the cumulative value of the even numbers upto it.
				else {
					i = (cha - 11)/2;
				}	
				bonusCha = bonusCha + i;
			}	
			else {
				//If cha is an odd number below 10
				if (cha < 10){
					if (cha % 2 == 1){
						i = (11-cha)/2;
					}
				
					//If cha is an even number below 10, add the cumulative value of the even numbers upto it.
					else {
						i = (10-cha)/2;
					}
					bonusCha = bonusCha - i;
				}
			}	
			
			//No sign if the Bonus is 0
			if (bonusCha == 0) {
				System.out.println("cha: " + cha + " " + bonusCha);
			}
			//Put the sign if it is a positive or a negative integer
			else {
				System.out.printf("cha: %d %+d\n", cha, bonusCha);
			}
			//Calculate hitPoints
			hitPoints = (int)(level * (Math.random()*1000 %6+1)+bonusCon);
			//Print hitPoints
			System.out.println("HP: " + hitPoints);		
			
			//Let the user select whether to re-roll or to accept the values
			System.out.println("Do you want to roll again ? Enter Y for yes, any other character for no.");
			userChoice = scan0.next();
			if (userChoice.equals("Y")){
				roll =  true;
			}
			else {
				if (userChoice.equals("y")) {
					roll = true;
				}
				else {
					roll = false;
				}
			}
		}while(roll);
		
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();		
			System.out.println("These are the values you got.");
			System.out.println("level : "+level);
			if (bonusStr==0) {
				System.out.println("str: " + str + " " + bonusStr);
			}
			else {
				System.out.printf("str: %d %+d\n", str, bonusStr);
			}
			if (bonusDex==0) {
				System.out.println("dex: " + dex + " " + bonusDex);
			}
			else {
				System.out.printf("dex: %d %+d\n", dex, bonusDex);
			}
			if (bonusCon==0) {
				System.out.println("con: " + con + " " + bonusCon);
			}
			else {
				System.out.printf("con: %d %+d\n", con, bonusCon);
			}
			if (bonusInt==0) {
				System.out.println("Int: " + Int + " " + bonusInt);
			}
			else {
				System.out.printf("Int: %d %+d\n", Int, bonusInt);
			}
			if (bonusWis==0) {
				System.out.println("wis: " + wis + " " + bonusWis);
			}
			else {
				System.out.printf("wis: %d %+d\n", wis, bonusWis);
			}
			if (bonusCha==0) {
				System.out.println("cha: " + cha + " " + bonusCha);
			}
			else {
				System.out.printf("cha: %d %+d\n", cha, bonusCha);
			}
			System.out.println("HP: " + hitPoints);
			System.exit(0);

		scan0.close();
	}	
}

