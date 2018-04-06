package com.co.micros.sha_pdf;

import java.io.Serializable;

public class Pdf implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sha;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	
	public Pdf() {
		super();
	}
	public Pdf(String name, String sha) {
		super();
		this.name = name;
		this.sha = sha;
	}
	
	

}
