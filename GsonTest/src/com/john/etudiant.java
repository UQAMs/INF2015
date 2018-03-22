package com.john;

public class etudiant {
String code;
String nom;
String prenom;

public etudiant(String code, String nom, String prenom) {
	
	this.code = code;
	this.nom = nom;
	this.prenom = prenom;
}

public String toString() {

	return nom + "," + prenom + " - " + code;
}

public String code () {
	
	return code;
}

public String nom () {
	
	return nom;
}

public String prenom() {
	
	return prenom;
}
}
