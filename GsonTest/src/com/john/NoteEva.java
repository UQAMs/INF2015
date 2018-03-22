package com.john;

import java.text.DecimalFormat;

public class NoteEva {

	String nomEva;
	String ponderation;
	int note;
	double moyenne;
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
	
	public NoteEva (String nomEva, String ponderation, int note, double moyenne) {
		
		this.nomEva = nomEva;
		this.ponderation = ponderation;
		this.note = note;
		this.moyenne = moyenne;

	}
	
	
	public String toString() {
		
		return nomEva + " " + ponderation + " " + note + " " + df2.format(moyenne);
	}
	
	public String nomEva() {
		
		return nomEva;
	}
	
	public String ponderation() {
		
		return ponderation;
	}
	
	public int note () {
		
		return note;
	}
	
	public double moyenne() {
		
		return moyenne;
	}
	
	public int ponderationInt() {
		
		String s = ponderation.substring(0, ponderation.length() - 1);
		int x = Integer.parseInt(s);
		
		return x;
	}
	
	public String TP() {
		
		if (nomEva.length() < 12) {
			int x = 12 - nomEva.length();
			for(int i = 0; i < x; i++) {
				nomEva = nomEva + " ";
			}
		}
		return nomEva;
	}
}
