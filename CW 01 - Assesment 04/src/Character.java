import java.util.Scanner;
import java.io.IOException;
//Store data about characters
public class Character extends Object{
		
	private static int level; //level taken from console
	private static int userInput; //temp var for holding user choice of character 
	private static int diceType;//Number of faces in the die relevat to the character class
	private static int[] abilityValue;//Abilities of the character 
	private static int hpAbilityElement = 2;//the index of value of con to be used in calculation of hitpoints
	private static String[] abilityName = {"Strength", "Dexterity", "Constitution", "Intelligence","Wisdom","Charisma"};
	private static int[] abilityBonus;//Array of bonuses for abilities
	//Array for character names
	static String[] characterClass = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard", "Blood Hunter"};
	//Array for number of die faces for the certain character
	int[] dFaces = {12, 8, 8, 8, 10, 8, 10, 10, 8, 6, 8, 6, 10};
	static int hitPoints = 0;	
		
	public Character() {
		super();
		defInitCharacterVars();
		readLevel();
		readUserInput();
		readUserConfirmation();
		
	}
	public void defInitCharacterVars(){
		this.level=0;
		this.diceType=0;
		abilityValue = new int[6];
		for(int i=0;i<6;i++) { 
			this.abilityValue[i] = 0;	
		}
		
		abilityName = new String[6] ;
		abilityName[0] = "Strength       ";
		abilityName[1] = "Dexterity      ";
		abilityName[2] = "Constitution   ";
		abilityName[3] = "Intelligence   ";
		abilityName[4] = "Wisdom         ";
		abilityName[5] = "Charisma       ";
		
		dFaces = new int[13];
		dFaces[0] = 12;
		dFaces[4] = dFaces[6] = dFaces[7] = dFaces[12] = 10;
		dFaces[1] = dFaces[2] = dFaces[3] = dFaces[5] = dFaces[8] = dFaces[10] = 8;
		dFaces[9] = dFaces[11] = 6;
			
		abilityBonus = new int[6];
		for(int i=0;i<6;i++) { 
			this.abilityBonus[i] = 0;	
		}
	}
	
	public void readLevel() {
		Scanner scL = new Scanner(System.in);
		//Ask for level
		System.out.println("level ?");
		
		//Take the input for level
		if (scL.hasNextInt()) {	
			level = scL.nextInt();
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
	}
		
	public void readUserInput() {
		//Initializing the characterClass array
		for(int i =0; i<=12; i++) {
			System.out.println(i+" - "+ characterClass[i]);
		}
		System.out.println("Choose the number of your character from 0 to 12");

		Scanner scC = new Scanner(System.in);

		if(scC.hasNextInt()) {
			userInput = scC.nextInt();

			if(userInput<0){//reject the input if the userinput is less than 0
				System.err.println("Please enter a number between 0 - 12");
				}
			else{
				if (userInput>12){//reject the input if the userinput is greater than 12
					System.err.println("Please enter a number between 0 - 12");
				}
				else {//if the input is between 0 - 12, select the diceType related to the character
					diceType = dFaces[userInput];
				}
			}
		}
		else {	//print error if it's not an integer input
			System.err.println("Invalid selection");
		}
		System.out.println("These are the values you got.");
	}
	
	public void generateAbilityStats() {
		//generate values for all six stats and calculate bonuses
		for(int i=0;i<6;i++) { 
			this.abilityValue[i] = dropLowestRoll(diceType);
			this.abilityBonus[i] = bonusCalc(this.abilityValue[i]);
		}
		
		//Calculate hitPoints
		hitPoints = (level) * ((int)(Math.random()*1000 %diceType+1)+getAbilityValue(hpAbilityElement));
	}	
	public static int dropLowestRoll(int dF) { //Method to generate a random number
		int rollValue;
		int min = 0;
		int x1, x2, x3, x4; 
		
		x1=rollDice(dF);
		min = x1; //Take the first random number as the Minimum. 

		x2=rollDice(dF);
		if(x2<min) { //Compare the second random number with the first one and take it as the min if it's lower than the first one. 
			min = x2;
		}

		x3=rollDice(dF);
		if (x3<min) {//Compare the third random number with the first one and take it as the min if it's lower than the first one.
			min = x3;
		}

		x4=rollDice(dF);
		if (x4<min) {//Compare the fourth random number with the first one and take it as the min if it's lower than the first one.
			min = x4;
		}

		//Calculate the value without the Minimum of the four random numbers
		rollValue = x1+x2+x3+x4-min;
		//Return the Value
		return rollValue;
	}

	public static int rollDice(int dieFaces) { 			
//		//Generate 3 Random numbers for each input and assign the sum of those three numbers for the input		
		int rolledValue = 0;
		rolledValue =(int)(Math.random()*1000 %dieFaces+1);
		return rolledValue;
	}

	public static int bonusCalc(int skillValue) { //
		int i = 0;
		int bonusTemp=0; //to manage negative bonus
		
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
		
	public void readUserConfirmation() {
		boolean Roll = true;
		String UserChoice = new String();
		Scanner scUC = new Scanner(System.in);

		do { //while user rejects the generated output	
			generateAbilityStats();
			printResult();
			
			//Let the user select whether to re-Roll or to accept the values
			System.out.println("Do you want to Roll again ? Enter Y for yes, any other character for no.");
			
			UserChoice = scUC.next();
			//check user choice
			if (UserChoice.equals("Y")){
				Roll =  true;
			}
			else {
				if (UserChoice.equals("y")) {
					Roll = true;
				}
				else {
					Roll = false;
				}
			}
		}while(Roll);
		
		printResult();	
	}

	public static void printResult() {
		//printing results
		System.out.println("Hit Dice       : \t"+ "d"+diceType);
		System.out.println("level          : \t"+ level);
		System.out.println("Character Name :\t" +  characterClass[userInput]);
		for (int i=0; i<6; i++) {
			bonusPrint(getAbilityName(i), getAbilityValue(i), getAbilityBonus(i));
		}
		System.out.println("Hit Points     : \t" + hitPoints);		
	}
	
	public static void bonusPrint(String TempName, int SkillPrint, int BonusPrint) { //
		//No sign if the Bonus is 0		
		if (BonusPrint == 0) {
			System.out.println(TempName +":\t" + SkillPrint  + "\t" + BonusPrint);
		}
		//Put the sign if it is a positive or a negative integer
		else {
			System.out.printf("%s:\t%d\t%+d\n", TempName, SkillPrint, BonusPrint);
		}
	}
	
	public static String getAbilityName(int i) {
		return abilityName[i];
	}
		
	public static int getAbilityValue(int i) {
		return abilityValue[i];
	}
		
	public static int getAbilityBonus(int i) {
		return abilityBonus[i];
	}
}