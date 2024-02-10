package com.prospecta.PublicAPIsAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.PublicAPIsAPI.model.EntryDTO;
import com.prospecta.PublicAPIsAPI.service.PublicAPIService;

@RestController
public class PublicAPIController {
	private PublicAPIService ps;
	
	@Autowired
	 public PublicAPIController(PublicAPIService ps) {
		super();
		this.ps = ps;
	}

	/**
	 * To retrieve data by category
	 * @param category
	 * @return
	 */
	    @GetMapping("/api/categories/{category}")
	    public ResponseEntity<List<EntryDTO>> listAPIsByCategory(@PathVariable String category) {
	        
	        List<EntryDTO> extractDataFromJSON = ps.fetchCat(category);
	        if(extractDataFromJSON.isEmpty()) {
	        	return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(extractDataFromJSON);
	    }

	    
	    
	    /**
	     * 
	     * 
	     * @return
	     */
	    @PostMapping("/api/entries")
	    public String saveNewEntry() {
	    	ps.fethData();
	        return "Saved Sucessfully";
	    }


		public PublicAPIController() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	   
}
