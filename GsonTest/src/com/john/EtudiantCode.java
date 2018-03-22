package com.john;

import java.util.ArrayList;
import java.util.Arrays;

public class EtudiantCode {
	
	String nom;
	String prenom;
	String code;
	ArrayList<NoteEva> notes = new ArrayList<>();
	
	public EtudiantCode (String nom, String prenom, String code, ArrayList<NoteEva> notes) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.code = code;
		this.notes = notes;
		
	}

	
	public String toString() {
		
		return nom + "," + prenom + " - " + code + notes;
	}
	
	public String nom() {
		
		return nom;
	}
	
	public String prenom () {
		
		return prenom;
	}
	
	public String code() {
		
		return code;
	}
	
	public ArrayList<NoteEva> note () {
		
		return notes;
	}
	
}
