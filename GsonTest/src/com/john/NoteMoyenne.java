package com.john;

public class NoteMoyenne {
	
	String code;
	String nomEva;
	String ponderation;
	int note;
	double moyenne;
	
	public NoteMoyenne (String code, String nomEva, String ponderation, int note, double moyenne) {
		
		this.code = code;
		this.nomEva = nomEva;
		this.ponderation = ponderation;
		this.note = note;
		this.moyenne = moyenne;
		
	}
	
	
	public String toString() {
		
		return code + nomEva + ponderation + note + moyenne;
	}
	
	public String code () {
		
		return code;
	}
	
public String nomEva () {
		
		return nomEva;
	}

public String ponderation () {
	
	return ponderation;
}

public int note () {
	
	return note;
}

public double moyenne () {
	
	return moyenne;
}

}
