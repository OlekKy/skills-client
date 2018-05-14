package com.ak.skillsclient.service.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ak.skillsclient.domain.DetailsDTO;
import com.ak.skillsclient.domain.DetailsFullDTO;
import com.ak.skillsclient.domain.DetailsNewDTO;
import com.ak.skillsclient.domain.SaveSkillsRequest;
import com.ak.skillsclient.domain.UserCreatedDTO;
import com.ak.skillsclient.domain.UserFullDTO;
import com.ak.skillsclient.domain.UserNewDTO;
import com.ak.skillsclient.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${resource.userdetails}")
    private String resource;
	@Value("${resource.users}")
    private String resourceUsers;
	@Value("${resource.usersalldetails}")
	private String resourceDetails;
	@Value("${resource.skills}")
    private String resourceSkills;
	@Value("${resource.usersskills}")
	private String resourceUserSkills;

	@Autowired
	private RestTemplate restTemplate;
	
	public static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true);
	}
	
	private static String getUsername() {
		HttpSession session = session();
		return (String)  session.getAttribute("userName");
	}
	private static String getPassword() {
		HttpSession session = session();
		return (String) session.getAttribute("password");
	}
	private static HttpHeaders getHeaders(){
		String username = getUsername();
		String password = getPassword();
        String plainCredentials=username+":"+password;
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
	// Get detailsDTO by detail id
	@Override
	public DetailsDTO getUserDetails(String id) {
		HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders());
		ResponseEntity<DetailsDTO> result = restTemplate.exchange(resource+id, HttpMethod.GET, entity, DetailsDTO.class);
		return result.getBody();
	}
	
	// Get DetailsFullDTO by user Id
	@Override
	public DetailsFullDTO getByUserId(String id) {
		HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders());
		ResponseEntity<DetailsFullDTO> result = restTemplate.exchange(resourceDetails+id, HttpMethod.GET, entity, DetailsFullDTO.class);
		return result.getBody();
	}
	
	 // Save specified skills to user by user Id and skills id
	@Override
	public UserFullDTO saveSpecifiedSkills(String userId, List<Long> listOfSkills) {
		SaveSkillsRequest saveSkillsReq = new SaveSkillsRequest(); 
		saveSkillsReq.setUserId(userId); //
		saveSkillsReq.setSkillsIds(listOfSkills);
		HttpEntity<SaveSkillsRequest> entity = new HttpEntity<SaveSkillsRequest>(saveSkillsReq, getHeaders());
		ResponseEntity<UserFullDTO> result = restTemplate.exchange(resourceUserSkills, HttpMethod.PUT, entity, UserFullDTO.class);
		return result.getBody();
	}

	// Create new User with name and email
	@Override
	public UserCreatedDTO createNewUser(String name, String email) {
		UserNewDTO userNewDTO = new UserNewDTO();
		userNewDTO.setName(name);
		userNewDTO.setEmail(email);
		HttpEntity<UserNewDTO> entity = new HttpEntity<UserNewDTO>(userNewDTO);
		URI re = restTemplate.postForLocation(resourceUsers, entity, UserNewDTO.class);
		UserCreatedDTO result = restTemplate.getForObject(re, UserCreatedDTO.class);
	    return result;
	}

	// Update user's details
	@Override
	public void updateDetails(DetailsNewDTO detailsNewDTO) {
		
		HttpEntity<DetailsNewDTO> entity = new HttpEntity<DetailsNewDTO>(detailsNewDTO, getHeaders());
		restTemplate.exchange(resource, HttpMethod.PUT, entity, DetailsNewDTO.class);	
	}

}
