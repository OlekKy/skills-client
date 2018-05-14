package com.ak.skillsclient.service;

import java.util.List;

import com.ak.skillsclient.domain.DetailsDTO;
import com.ak.skillsclient.domain.DetailsFullDTO;
import com.ak.skillsclient.domain.DetailsNewDTO;
import com.ak.skillsclient.domain.UserCreatedDTO;
import com.ak.skillsclient.domain.UserFullDTO;

public interface UserService {

	UserFullDTO saveSpecifiedSkills(String userId, List<Long> listOfSkills);
	DetailsDTO getUserDetails(String id);
	UserCreatedDTO createNewUser(String name, String email);
	DetailsFullDTO getByUserId(String id);
	void updateDetails(DetailsNewDTO detailsNewDTO);
}
