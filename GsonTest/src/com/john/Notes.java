package com.john;

public class Notes {

	String nom;
	double moyenne;
	
	public Notes (String nom, double moyenne) {
		
		this.nom = nom;
		this.moyenne = moyenne;
	}
	
	public String toString() {

		return nom + " moyenne : " + moyenne;
	}
	
	public String nom() {
		
		return nom;
	}
	
	public double moyenne() {
		
		return moyenne;
	}
	
}
