import java.util.*;
import java.io.*;
public class Skills {
	private String name;
	private String optional;
	private String short_desc;
	private int stat_affinity;
	private int ranks;
	SkillNode SkillFullList, TempNode, CurntNode, CharacterSkills, CurrentCSNode; //references to manipulate the linked lists - SkillFullList, CharacterSkills

	File TextFile = new File("Skills.txt");
	Scanner sc = new Scanner(new FileInputStream(TextFile));
	int count = 0;
	int characterSkillNumber[] = new int [13]; 
	private static boolean [][] CS = new boolean[13][18]; //multi- dimensional array to connect skills with characters

    public Skills(int characterNumber) throws IOException {
    	varInit();
    	listBuilder();
    	selectCharacterSkills(characterNumber);
    }
    
	//Define the matrix to hold skill availability of characters
	public void varInit() {
		for(int i = 0; i<13; i++) {
			for(int j = 0; j<18; j++) {
				CS [i][j]=false;
			}
		}

		//Marking the skills available for characters using the matrix
		CS[0][0] = CS[0][7] = CS[0][9] = CS[0][12] = CS[0][13] = CS[0][15] = CS[2][5] = CS[2][8] = CS[2][10] = CS[2][11]= CS[2][17] = CS[3][4] = CS[3][8] = CS[3][9] = CS[3][10] = CS[3][11] = CS[3][12] = CS[3][13] = CS[4][0] = CS[4][1] = CS[4][5] = CS[4][9] = CS[4][10] = CS[4][12] = CS[4][13] = CS[4][15] = CS[5][0] = CS[5][1] = CS[5][3] = CS[5][5] = CS[5][8] = CS[5][10] = CS[6][0] = CS[6][8] = CS[6][10] = CS[6][11] = CS[6][15] = CS[6][17] = CS[7][0] = CS[7][3] = CS[7][6] = CS[7][7] = CS[7][9] = CS[7][10] = CS[7][12] = CS[7][13] = CS[8][0] = CS[8][1] = CS[8][2] = CS[8][3] = CS[8][6] = CS[8][12] = CS[8][14] = CS[8][16] = CS[8][17] = CS[9][4] = CS[9][8] = CS[9][10] = CS[9][14] = CS[9][15] = CS[9][17] = CS[10][4] = CS[10][5] = CS[10][6] = CS[10][7] = CS[10][8] = CS[10][14] = CS[10][15] = CS[11][4] = CS[11][5] = CS[11][6] = CS[11][8] = CS[11][10] = CS[11][11] = CS[12][0] = CS[12][1] = CS[12][4] = CS[12][6] = CS[12][10] = CS[12][13] =true;
		//marking all the skills for the character Bard as all the skills are possible for that character
		for(int x = 0; x<18; x++) {
			CS[1][x] = true;
		}
		//assigning the number of skills for characters
		characterSkillNumber[0] = characterSkillNumber[2] = characterSkillNumber[3] = characterSkillNumber[4] = characterSkillNumber[5] = characterSkillNumber[6] = characterSkillNumber[9] = characterSkillNumber[10] = characterSkillNumber[11] = characterSkillNumber[12] = 2;
		characterSkillNumber[1] = characterSkillNumber[7] = 3;
		characterSkillNumber[8] = 4;
	}

	public void listBuilder() throws IOException {
		pickNodeData();
		SkillFullList = CurntNode = TempNode;
		
		while (sc.hasNextLine()){
			pickNodeData();
			CurntNode.setNextSkill(TempNode);
			CurntNode = TempNode;
		}
	}
	
	
	public void pickNodeData() {

		if (sc.hasNextLine()){
			name = sc.nextLine();
		}
		if (sc.hasNextLine()){
			optional = sc.nextLine();
		}
		if (sc.hasNextLine()){
			short_desc = sc.nextLine();
		}
		if (sc.hasNextInt()){
			stat_affinity = sc.nextInt();
		}
		if (sc.hasNextInt()){
			ranks = sc.nextInt();	
		}
		//creating a new node of skill using text file input
		TempNode = new SkillNode();
		TempNode.setName(name);
		TempNode.setOptional(optional);
		TempNode.setShortDesc(short_desc); 
		TempNode.setStatAffinity(stat_affinity); 
		TempNode.setRanks(ranks);
	}
	
	public void selectCharacterSkills(int characterNumber) {				
		Scanner scn = new Scanner(System.in);	
		String choice;
		
		count = characterSkillNumber[characterNumber];
		CharacterSkills = null;
		CurntNode = SkillFullList;
		int i = 0;
		System.out.println("\nTime to select Skills. Press Y to select, any other key to reject.");

		while((i<18)&&(count > 0)) {
			if(CS[characterNumber][i]) {
				//ask user if he accepts the skill
				System.out.println("\n"+CurntNode.getName()+" - "+CurntNode.getOptional()+" - "+CurntNode.getshortDesc()+"\n"+"Do you accept "+CurntNode.getName()+"?");
				choice = scn.next();
				if (choice.equals("Y")){
					//add to a linked list and prompt new skill
					moveCurntToTemp();
				}
				else {
					if (choice.equals("y")) {
						//add to a linked list and prompt new skill
						moveCurntToTemp();					
					}
					
				}	
			}
			
			CurntNode = CurntNode.getNextSkill();  
			i++;
		}
	}

	public void moveCurntToTemp() {
		//creating a new node of skill
		TempNode = new SkillNode();
		TempNode.setName(CurntNode.getName());
		TempNode.setOptional(CurntNode.getOptional());
		TempNode.setShortDesc(CurntNode.getshortDesc());
		TempNode.setStatAffinity(CurntNode.getStatAffinity());
		TempNode.setRanks(CurntNode.getRanks());
		TempNode.setNextSkill(null); 
		
		if(CharacterSkills == null) {
			CharacterSkills = CurrentCSNode = TempNode; 
		}
		else {
			CurrentCSNode.setNextSkill(TempNode); 
			CurrentCSNode = TempNode;
		}
		count--;
	}
	
	public void printSkills() {
		if(CharacterSkills == null) {//if user hasnt selected any skills
			System.out.println("No skills to print");
			return;
		}
		else {//if there are any selected skills
			System.out.println("Chosen Skills of the Character are:");
		}
		CurntNode = CharacterSkills;
		while(CurntNode != null) {	
			System.out.println(CurntNode.getName());
			CurntNode = CurntNode.getNextSkill();
		}
	}
}	