 public class SkillNode {
	String name;
	String optional;
	String short_desc;
	int stat_affinity;
	int ranks;
	SkillNode next_Skill;
	
	public void SkillNode() {
		next_Skill = null;
	}
	public void setNextSkill(SkillNode nLink){
		next_Skill = nLink;
	}

	public SkillNode getNextSkill(){
		return next_Skill;
	}

	public void setName(String inName){
		name = inName;
	}

	public String getName(){
		return name;
	}

	public void setOptional(String inOptional){
		optional = inOptional;
	}

	public String getOptional(){
		return optional;
	}

	public void setShortDesc(String inShortDesc){
		short_desc = inShortDesc;
	}

	public String getshortDesc(){
		return short_desc;
	}

	public void setStatAffinity(int inStatAffinity){
		stat_affinity = inStatAffinity;
	}

	public int getStatAffinity(){
		return stat_affinity;
	}

	public void setRanks(int inRanks){
		ranks = inRanks;
	}

	public int getRanks(){
		return ranks;
	}

}
