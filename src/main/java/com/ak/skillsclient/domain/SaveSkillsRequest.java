package com.ak.skillsclient.domain;

import java.util.List;

public class SaveSkillsRequest {

	private List<Long> skillsIds;
	private String userId;
	public List<Long> getSkillsIds() {
		return skillsIds;
	}
	public void setSkillsIds(List<Long> skillsIds) {
		this.skillsIds = skillsIds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
