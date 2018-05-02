package com.example;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
public class HttpUtil {
	
	String YSBURL = "http://192.168.9.81";

	private TestRestTemplate template = new TestRestTemplate();

	public JSONObject UNSPost(String url, Map<String, Object> request) throws JsonProcessingException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(request);
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
	
		HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
		String body =template.postForObject(YSBURL + url, httpEntity, String.class);
		body = UUIDGenerator.info(body);
		
		JSONObject obj = new JSONObject(body);
		return obj;

	}
	
		


}
