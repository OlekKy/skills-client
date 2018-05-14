package com.ak.skillsclient.domain;

public class SkillDTO {

	int id;
	String skillName;
	
	public SkillDTO() {
		
	}
	public SkillDTO(String skillName) {
		super();
		this.skillName = skillName;
	}
	public SkillDTO(int id, String skillName) {
		super();
		this.id = id;
		this.skillName = skillName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
