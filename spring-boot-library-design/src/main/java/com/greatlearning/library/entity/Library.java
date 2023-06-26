package com.greatlearning.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Library {
	
	@Id
	private long id;
	private String name;
	private String commaSeperatedBooknames;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommaSeperatedBooknames() {
		return commaSeperatedBooknames;
	}
	public void setCommaSeperatedBooknames(String commaSeperatedBooknames) {
		this.commaSeperatedBooknames = commaSeperatedBooknames;
	}
	
}
