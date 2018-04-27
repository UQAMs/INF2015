package com.john;

public class Couler {
	
	String code;
	String nom;
	String prenom;
	int noteG;

	public Couler (String code, String nom, String prenom, int noteG) {
		
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.noteG = noteG;
	}
	
	public String code () {
		return code;
	}
	public String nom () {
		return nom;
	}
	public String prenom () {
		return prenom;
	}
	public int noteG () {
		return noteG;
	}
	
	public String toString() {
		return code + "        " + nom + "   " + prenom + "     " + noteG + "/100" + "    " + noteG + "%";
	}

}
