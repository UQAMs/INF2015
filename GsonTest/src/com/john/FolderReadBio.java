package com.john;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class FolderReadBio {

	static ArrayList<Evaluation> evaBio = new ArrayList<>();
	static ArrayList<Notes> notBio = new ArrayList<>();
	static int i = 0;
	static double moyenne;
	static String nom;
	static int total = 0;
	static int compteur = 0;
    
    public static void readFolderBio(String folderPath) throws IOException
    {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        
        Gson gson = new Gson();
		BufferedReader br = null;
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                //System.out.println(file.getPath());
                try {
                	InputStream inputStream = new FileInputStream(file.getPath()); 
                	InputStreamReader streamReader = new InputStreamReader(inputStream);
        			br = new BufferedReader(streamReader);
        			Result result = gson.fromJson(br, Result.class);
        			nom = result.getNomEvaluation();
        			if(result != null ) {
        				for(Donnee t: result.getDonnees()) {
        					evaBio.add(new Evaluation(result.getNomEvaluation(),result.getPonderation(),t.getCodePermanent(),t.getNote()));
        					total = total + t.getNote();
        					compteur++;
        					i++;
        					
        				}
        			}
        			
        			
        		} catch (FileNotFoundException e) {
        		
        			e.printStackTrace();
               }
            } 
    			if(br != null) {
    				try {
    					br.close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			
    			moyenne = (double)total/(double)compteur;
    			notBio.add(new Notes(nom, moyenne));
        		total = 0;
        		compteur = 0;
        		nom = null;
        		//System.out.println(notBio);
    		}
        		
        //System.out.println(evaBio);
    	}
    	
    }
