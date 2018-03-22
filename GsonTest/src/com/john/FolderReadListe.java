package com.john;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class FolderReadListe {
	static etudiant [] etu = new etudiant[14];
	static etudiant [] eBio = new etudiant[6];
	static etudiant [] eMat = new etudiant[8];
	static int i = 0;
	static int o = 6;
	

    
    public static void readFolderListe(String folderPath) throws IOException
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
        			
        			if(result != null ) {
        				for(Donnee t: result.getDonnees()) {
        					etu[i] = new etudiant(t.getCodePermanent(), t.getNom(),t.getPrenom());
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
    			
    			
    		}
        		for(int k = 0; k < 6; k++) {
        			eBio[k] = etu[k];
        			//System.out.println(eBio[k].toString());
        		}
        		
        		//System.out.println("--------------------------------------------");
        		
        		for(int k = 0; k < 8; k++) {
        			eMat[k] = etu[o];
        			//System.out.println(eMat[k].toString());
        			o++;
        		}
       
    	}
    	
    }
