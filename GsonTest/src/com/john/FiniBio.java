package com.john;

import java.util.Date;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FiniBio {
	
	private static DecimalFormat df2 = new DecimalFormat(".#");
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d-MM-yyyy HH:mm:ss");
	static int noteG = 0;
	static int totalG = 0;
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
		writer.close();
		noteG = 0;
		totalG = 0;
	}

}
}