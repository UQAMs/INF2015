package com.john;


public class Evaluation {
String nomEval;
String ponderation;
String code;
int note;


public Evaluation(String nomEval, String ponderation, String code, int note) {
	
	this.nomEval = nomEval;
	this.ponderation = ponderation;
	this.code = code;
	this.note = note; 

}

public String toString() {

	return code + "   " + nomEval + "   " + ponderation + "   " + note;
		
}

public String nomEval() {
	
	return nomEval;
}

public String ponderation() {
	
	return ponderation;
}

public String code () {
	
	return code;
}

public int note() {
	
	return note;
}

}


