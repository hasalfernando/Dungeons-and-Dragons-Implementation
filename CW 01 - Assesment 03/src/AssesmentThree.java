import java.io.IOException;
import java.util.Scanner;
public class AssesmentThree{
	public static int rollDice(int dieFaces) { //roll a die and send a value
		int rolledValue = 0;
		rolledValue =(int)(Math.random()*1000 %dieFaces+1);
		return rolledValue;
	}
	public static int dropLowestRoll() { //Method to generate a random number
		int dFaces = 6;
		int rollValue;
		int Min;
		int x1, x2, x3, x4;
		
		x1=rollDice(dFaces);
		
		//int x1 =(int)(Math.random()*1000 %6+1);
		Min = x1; //Take the first random number as the Minimum. 
		x2=rollDice(dFaces);
		if(x2<Min) { //Compare the second random number with the first one and take it as the Min if it's lower than the first one. 
			Min = x2;
		}
		x3=rollDice(dFaces);
		if (x3<Min) {//Compare the third random number with the first one and take it as the Min if it's lower than the first one.
			Min = x3;
		}
		x4=rollDice(dFaces);
		if (x4<Min) {//Compare the fourth random number with the first one and take it as the Min if it's lower than the first one.
			Min = x4;
		}
		//Calculate the value without the Minimum of the four random numbers
		rollValue = x1+x2+x3+x4-Min;
		//Return the Value
		return rollValue;
	}
	
	public static int bonusCalc(int skillValue) { //
	int i = 0;
	int bonusTemp=0;

	if (skillValue > 10){
		//If skillValue is an even number above 10, cumulative +1 for each even number above 10
		if (skillValue % 2 == 0){ 
			i = (skillValue - 10)/2;
		}
		//If skillValue is an odd number above 10, add the cumulative value of the even numbers upto it.
		else {
			i = (skillValue - 11)/2;
		}
		bonusTemp = i;
	}
	else {
		if (skillValue < 10){
			//If skillValue is an odd number below 10, cumulative -1 for each odd number below 10
			if (skillValue % 2 == 1){ 
				i = (11-skillValue)/2;
			}
			//If skillValue is an even number below 10, add the cumulative value of the odd numbers upto it.
			else { //If the skillValue is 10, the bonus will be 0.
				i = (10-skillValue)/2;
			}
			bonusTemp = bonusTemp - i;
		}
		else {
			bonusTemp = 0;
		}
	}		
	return bonusTemp;
	}

	public static void BonusPrint(String TempName, int SkillPrint, int BonusPrint) { //
		//No sign if the Bonus is 0		
		if (BonusPrint == 0) {
			System.out.println(TempName + SkillPrint  + " " + BonusPrint);
		}
		//Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("%s%d %+d\n", TempName, SkillPrint, BonusPrint);
		}
	}
	
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
			
			str = AssesmentThree.dropLowestRoll();
			dex = AssesmentThree.dropLowestRoll();
			con = AssesmentThree.dropLowestRoll();
			Int = AssesmentThree.dropLowestRoll();
			wis = AssesmentThree.dropLowestRoll();
			cha = AssesmentThree.dropLowestRoll();

			//Print level 
			System.out.println("level : "+level);
			
			bonusStr= AssesmentThree.bonusCalc(str);
			BonusPrint("str: ", str, bonusStr);

			bonusDex= AssesmentThree.bonusCalc(dex);
			BonusPrint("dex: ", dex, bonusDex);
		
			bonusCon= AssesmentThree.bonusCalc(con);
			BonusPrint("con: ", con, bonusCon);

			bonusInt= AssesmentThree.bonusCalc(Int);
			BonusPrint("Int: ", Int, bonusInt);

			bonusWis = AssesmentThree.bonusCalc(wis);
			BonusPrint("wis: ", wis, bonusWis);

			bonusCha = AssesmentThree.bonusCalc(cha);
			BonusPrint("cha: ", cha, bonusCha);
			
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
		 	//clear the console
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			//Print the accepted values
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

