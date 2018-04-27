package com.john;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		FolderReadListe.readFolderListe("TP\\Liste");	
		FolderReadBio.readFolderBio("TP\\BIO1012");
		FolderReadMat.readFolderMat("TP\\MAT1411");
		Texte.textBio();
		Texte.textMat();
		FiniMat.afficher();
		FiniBio.afficher();
		FiniBio.stats();
		FiniMat.stats();
		FiniBio.regi();
		FiniMat.regi();
		FiniMat.suivi();
		FiniBio.suivi();
	}
	
}
