package com.john;

import com.google.gson.stream.JsonWriter;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;

public class FiniBio {
	
	private static DecimalFormat df2 = new DecimalFormat(".#");
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-MM-yyyy HH:mm:ss");
	static int noteG = 0;
	static int totalG = 0;
	static ArrayList<String> code = new ArrayList<>();
	static ArrayList<Integer> notes = new ArrayList<>();
	static ArrayList<Couler> coule = new ArrayList<>();

	
	public static void afficher() throws FileNotFoundException, UnsupportedEncodingException {
		
		for(int i = 0; i < Texte.etud.length; i++) {
			PrintWriter writer = new PrintWriter("TP\\ResultatsBio\\"+Texte.etud[i].code+".txt", "UTF-16");
			
		//writer.println("");
		writer.println(Texte.etud[i].nom + "," + Texte.etud[i].prenom + " - " + Texte.etud[i].code + "              date : " + simpleDateFormat.format(new Date()));
		writer.println("");
		writer.println("Evalutation    ponderation    note      moyenne       note globale");
		
		NoteEva[] note = Texte.etud[i].notes.toArray(new NoteEva[Texte.etud[i].notes.size()]);
		
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
			writer.println(note[k].nomEva + "       " + note[k].ponderation() + "        " + note[k].note + "/" + note[k].ponderationInt() +"      " + df2.format(note[k].moyenne) + "            " + noteG + "/" + totalG);
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
		
		PrintWriter writer = new PrintWriter("TP\\ResultatsBio\\Statistique.txt", "UTF-16");
		writer.println("BIO1012 Gr10");
		writer.println("Date : " + simpleDateFormat.format(new Date()));
		writer.println("");
		writer.println("Évaluation   moyenne    mode    médiane   écart-type   étudiants");
		writer.println("");
		while(!FolderReadBio.infBio.isEmpty()) {
			writer.println(FolderReadBio.infBio.remove(0)); 
		}
		
		writer.close();
		
	}
	
public static void regi () throws FileNotFoundException, UnsupportedEncodingException {
		
		JsonWriter writer;
		
		try {
			writer = new JsonWriter(new FileWriter("TP\\ResultatsBio\\Releve.json"));
			
			writer.beginObject();
			writer.name("Cours").value("BIO1012");
			writer.name("Groupe").value("10");
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
	
	PrintWriter writer = new PrintWriter("TP\\ResultatsBio\\suivi.txt", "UTF-16");
	writer.println("BIO1012 Gr10");
	writer.println("Date : " + simpleDateFormat.format(new Date()));
	writer.println("");
	writer.println("Code permanant   nom    prenom    note   pourcentage");
	writer.println("");
	while(!coule.isEmpty()) {
		writer.println(coule.remove(0));
	}
		
	}
}