package com.prospecta.PublicAPIsAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String auth;
	private boolean https;
	private String cors;
	private String link;
	private String category;
	
	
	public Entry( String name, String description, String auth, boolean https, String cors, String link,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.auth = auth;
		this.https = https;
		this.cors = cors;
		this.link = link;
		this.category = category;
	}
	
	
	
	

}
