package com.prospecta.PublicAPIsAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prospecta.PublicAPIsAPI.model.Entry;
import com.prospecta.PublicAPIsAPI.model.EntryDTO;
import com.prospecta.PublicAPIsAPI.repository.PubilcAPIRepository;

@Service
public class PublicAPIServiceImpl implements PublicAPIService {
	
	public PubilcAPIRepository pr;
	
	@Value("${publicUrl}")
	private String url;
	
	public RestTemplate restTemplate ;
	
	

	
	@Autowired
	public PublicAPIServiceImpl( PubilcAPIRepository pr) {
		
		this.pr = pr;
		this.restTemplate = new RestTemplate();
	}

	@Override
	public List<EntryDTO> extractToJson(String jsonResponse) {
		// TODO Auto-generated method stub
		 try {
	            ObjectMapper mapper = new ObjectMapper();
	            JsonNode root = mapper.readTree(jsonResponse);
	            
	            
	            for (JsonNode entry : root.path("entries")) {
	                String name = entry.path("API").asText();
	                String description = entry.path("Description").asText();
	                String cat = entry.path("Category").asText();
	                String auth =entry.path("Auth").asText();
	                boolean https = entry.path("Https").asBoolean();
	                String cors = entry.path("Cors").asText();
	                String link = entry.path("Link").asText();
	                pr.save(new Entry(name,description,auth,https,cors,link,cat));
	          }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return null;
	}

	
	@Override
	public List<EntryDTO> extractDataFromJSON(String jsonResponse) {
		
		        
		        List<EntryDTO> list = new ArrayList<>();
		        try {
		            ObjectMapper mapper = new ObjectMapper();
		            JsonNode root = mapper.readTree(jsonResponse);
		            
		            
		            for (JsonNode entry : root.path("entries")) {
		                String name = entry.path("API").asText();
		                String description = entry.path("Description").asText();
		                String cat = entry.path("Category").asText();
		                list.add(new EntryDTO(name,description,cat));
		          }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return list;
		    

	}

	@Override
	public String fetchDataFromAPI(String apiUrl) {
		
		// RestTemplate restTemplate = new RestTemplate();
	       // System.out.println(restTemplate.getForObject(apiUrl, String.class));
	        return restTemplate.getForObject(apiUrl, String.class);
	}



	@Override
	public void fethData() {
		// TODO Auto-generated method stub
		String fetchDataFromAPI = fetchDataFromAPI(url+"/entries");
		List<EntryDTO> extractToJson = extractToJson(fetchDataFromAPI);
		System.out.println(url+"/entries");
	}

	@Override
	public List<EntryDTO> fetchCat(String category) {
		// TODO Auto-generated method stub
		String categoryUrl = url + "/entries?category=" + category;
        String fetchDataFromAPI = fetchDataFromAPI(categoryUrl);
        
        List<EntryDTO> extractDataFromJSON = extractDataFromJSON(fetchDataFromAPI);
        return extractDataFromJSON;
    }

	public PublicAPIServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
