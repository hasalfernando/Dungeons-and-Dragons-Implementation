import java.io.*;
import java.util.Scanner;

public class AssesmentFive {
	//define and initialize variables of the class
	static String userChoice ="";
	static Scanner sc = new Scanner(System.in);
		
	public static void main (String [] args) throws IOException {
		//call the createCharacter method
		createCharacter();
		
		//check user input to call the createCharacter again
		while((userChoice.equals("Y")) || (userChoice.equals("y"))){
			createCharacter();
		} 
		System.out.println("End of Program !");
		System.exit(0);
	}	
	public static void createCharacter() throws IOException {
		//create character
		Character playerCharacter = new Character();
		playerCharacter.printFinalResult();
		System.out.println("Do you want to create a different Character ? ");
		System.out.println("Press Y for Yes or any other character for No");
		userChoice = sc.next();
	}
}