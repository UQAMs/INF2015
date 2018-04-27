package com.john;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.stream.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FiniMat {
	
	private static DecimalFormat df2 = new DecimalFormat(".#");
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-MM-yyyy HH:mm:ss");
	static int noteG = 0;
	static int totalG = 0;
	static ArrayList<String> code = new ArrayList<>();
	static ArrayList<Integer> notes = new ArrayList<>();
	static ArrayList<Couler> coule = new ArrayList<>();
	
	public static void afficher() throws FileNotFoundException, UnsupportedEncodingException {
		
		for(int i = 0; i < Texte.etud.length; i++) {
			
			PrintWriter writer = new PrintWriter("TP\\ResultatsMat\\"+Texte.etudm[i].code+".txt", "UTF-16");
			
			
		//System.out.println("");
		writer.println(Texte.etudm[i].nom + "," + Texte.etudm[i].prenom + " - " + Texte.etudm[i].code + "              date : " + simpleDateFormat.format(new Date()));
		writer.println("");
		writer.println("Evalutation    ponderation    note      moyenne       note globale");
		
		NoteEva[] note = Texte.etudm[i].notes.toArray(new NoteEva[Texte.etudm[i].notes.size()]);
		
		for(int o = 0; o < note.length; o++) {
			
			noteG = noteG + note[o].note;
		}
		
		for(int x = 0; x < note.length; x++) {
			
			totalG = totalG + note[x].ponderationInt();
		}
		
		for(int k = 0; k < note.length; k++) {
			if(note[k] == null) {
				
				writer.println("");
			}
			note[k].TP();
			String s = note[k].nomEva;
			int g = note[k].note;
			
			if(s.length() > 13) {
				writer.println(note[k].nomEva + " " + note[k].ponderation() + "        " + note[k].note + "/" + note[k].ponderationInt() +"        " + df2.format(note[k].moyenne) + "            " + noteG + "/" + totalG);
			} else {
				if (g < 10) {
					
					writer.println(note[k].nomEva + "       " + note[k].ponderation() + "        " + note[k].note + "/" + note[k].ponderationInt() +"        " + df2.format(note[k].moyenne) + "            " + noteG + "/" + totalG);
				} else {
					
					writer.println(note[k].nomEva + "       " + note[k].ponderation() + "        " + note[k].note + "/" + note[k].ponderationInt() +"       " + df2.format(note[k].moyenne) + "           " + noteG + "/" + totalG);
					
				}
			}
		}
		code.add(Texte.etud[i].code);
		notes.add(noteG);
		if(noteG < 60) {
			coule.add(new Couler(Texte.etud[i].code,Texte.etud[i].nom,Texte.etud[i].prenom,noteG));
		}
		writer.close();
		noteG = 0;
		totalG = 0;
	}

}
public static void stats () throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("TP\\ResultatsMat\\Statistique.txt", "UTF-16");
		writer.println("MAT1411 Gr 20");
		writer.println("Date : " + simpleDateFormat.format(new Date()));
		writer.println("");
		writer.println("Évaluation   moyenne    mode    médiane   écart-type   étudiants");
		writer.println("");
		while(!FolderReadMat.infMat.isEmpty()) {
			writer.println(FolderReadMat.infMat.remove(0)); 
		}
		
		writer.close();
		
	}

public static void regi () throws FileNotFoundException, UnsupportedEncodingException {
	
	JsonWriter writer;
	
	try {
		writer = new JsonWriter(new FileWriter("TP\\ResultatsMat\\Releve.json"));
		
		writer.beginObject();
		writer.name("Cours").value("MAT1411");
		writer.name("Groupe").value("20");
		writer.name("\nDonees");
		writer.beginArray();
		
		while(!code.isEmpty()) {
			writer.beginObject();
			writer.name("code_permanant").value(code.remove(0));
			writer.name("note").value(notes.remove(0));
			writer.endObject();
		}
			
		
		writer.endArray();
		writer.endObject();
		writer.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	     }
	}

public static void suivi () throws FileNotFoundException, UnsupportedEncodingException {
	
	PrintWriter writer = new PrintWriter("TP\\ResultatsMat\\Suivi.txt", "UTF-16");
	writer.println("MAT1411 Gr 20");
	writer.println("Date : " + simpleDateFormat.format(new Date()));
	writer.println("");
	writer.println("Code permanant   nom    prenom    note   pourcentage");
	writer.println("");
	while(!coule.isEmpty()) {
		writer.println(coule.remove(0));
	}
	
	writer.close();
	
}
}