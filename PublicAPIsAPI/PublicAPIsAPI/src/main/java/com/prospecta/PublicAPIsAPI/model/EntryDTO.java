package com.prospecta.PublicAPIsAPI.model;


public class EntryDTO {
	
	private String Name;
	private String Description;
	private String Category;
	public EntryDTO(String name, String description, String category) {
		super();
		this.Name = name;
		this.Category = category;
		this.Description = description;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	@Override
	public String toString() {
		return "EntryDTO [Name=" + Name + ", Description=" + Description + ", Category=" + Category + "]";
	}
	
	
	

}
