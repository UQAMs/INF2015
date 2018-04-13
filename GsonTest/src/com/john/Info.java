package com.john;

import java.text.DecimalFormat;

public class Info {
	
	private static DecimalFormat df2 = new DecimalFormat(".#");
	
	String nom;
	double moyenne;
	int mode;
	double mediane;
	double ecart;
	int nbr;
	
	public Info (String nom, double moyenne, int mode, double mediane, double ecart, int nbr) {
		this.nom = nom;
		this.moyenne = moyenne;
		this.mode = mode;
		this.mediane = mediane;
		this.ecart = ecart;
		this.nbr = nbr;
	}
	public String toString() {

		return nom + "  " + df2.format(moyenne) + "       " + mode + "       " + df2.format(mediane) + "        " + df2.format(ecart) + "          " + nbr;
	}
	
	public String nom() {
		
		return nom;
	}
	
	public double moyenne() {
		
		return moyenne;
	}
	
	public int mode() {
		
		return mode;
	}
	
	public double mediane() {
		
		return mediane;
	}
	
	public double ecart() {
		
		return ecart;
	}
	
	public int nbr() {
		
		return nbr;
	}

}
