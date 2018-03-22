package com.john;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		FolderReadListe.readFolderListe("C:\\Users\\John\\Desktop\\TP\\Liste");	
		FolderReadBio.readFolderBio("C:\\Users\\John\\Desktop\\TP\\BIO1012");
		FolderReadMat.readFolderMat("C:\\Users\\John\\Desktop\\TP\\MAT1411");
		Texte.textBio();
		Texte.textMat();
		FiniMat.afficher();
		FiniBio.afficher();
		
		
	}
	
}
