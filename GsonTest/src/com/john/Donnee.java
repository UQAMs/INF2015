package com.john;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Donnee {

	@SerializedName("code_permanent")
	@Expose
	private String codePermanent;
	
	@SerializedName("note")
	@Expose
	private Integer note;
	
	@SerializedName("nom")
	@Expose
	private String nom;
	
	@SerializedName("prenom")
	@Expose
	private String prenom;
	
	public String getCodePermanent() {
		return codePermanent;
	}

	public void setCodePermanent(String codePermanent) {
		this.codePermanent = codePermanent;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}