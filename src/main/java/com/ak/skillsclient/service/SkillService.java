package com.ak.skillsclient.service;

import java.util.List;

import com.ak.skillsclient.domain.SkillDTO;

public interface SkillService {

	List<SkillDTO> findAllSkills();
	void addNewSkill(String skillName);
}
