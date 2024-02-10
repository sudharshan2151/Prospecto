package com.prospecta.PublicAPIsAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prospecta.PublicAPIsAPI.model.EntryDTO;

public interface PublicAPIService {
	
	List<EntryDTO> extractToJson(String jsonResponse);
	List<EntryDTO> extractDataFromJSON(String fetchDataFromAPI);
	String fetchDataFromAPI(String entriesUrl);
	void fethData();
	List<EntryDTO> fetchCat(String categoryUrl);
}
