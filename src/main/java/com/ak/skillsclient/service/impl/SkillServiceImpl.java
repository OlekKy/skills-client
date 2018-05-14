package com.ak.skillsclient.service.impl;


import java.util.Arrays;
import java.util.List;

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

import com.ak.skillsclient.domain.SkillDTO;
import com.ak.skillsclient.domain.SkillNewDTO;
import com.ak.skillsclient.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Value("${resource.skills}")
    private String resource;
	
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
	
	public List<SkillDTO> findAllSkills() {
		HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders());
	    ResponseEntity<SkillDTO[]> result = restTemplate.exchange(resource, HttpMethod.GET, entity, SkillDTO[].class);
        return Arrays.asList(result.getBody());
    }
     
	public void addNewSkill(String skillName) {
		SkillNewDTO skillNewDTO = new SkillNewDTO();
		skillNewDTO.setSkillName(skillName);		
		HttpEntity<SkillNewDTO> entity = new HttpEntity<SkillNewDTO>(skillNewDTO, getHeaders());
		restTemplate.postForLocation(resource, entity, SkillNewDTO.class);
	}
	
}
