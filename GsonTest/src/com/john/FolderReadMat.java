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
import java.util.Arrays;

import com.google.gson.Gson;

public class FolderReadMat {

	static ArrayList<Evaluation> evaMat = new ArrayList<>();
	static ArrayList<Notes> notMat = new ArrayList<>();
	static ArrayList<Info> infMat = new ArrayList<>();
	static ArrayList<Integer> notes = new ArrayList<>();
	static double moyenne;
	static double mediane;
	static int note;
	static int md;
	static int mode;
	static double ec;
	static double ect;
	static double equart;
	static String nom;
	static int total;
	static int compteur;
	static int i = 0;

    
    public static void readFolderMat(String folderPath) throws IOException
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
        					evaMat.add(new Evaluation(result.getNomEvaluation(),result.getPonderation(),t.getCodePermanent(),t.getNote()));
        					total = total + t.getNote();
        					note = t.getNote();
        					notes.add(note);
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
    			
int [] listenote = new int[compteur];
    			
    			moyenne = (double)total/(double)compteur;
    			//System.out.println(notes.remove(0));

    			while(!notes.isEmpty()) {
    				for(int i = 0; i< compteur; i++) {
    					listenote[i] = notes.remove(0);
    					ec = java.lang.Math.pow((listenote[i]-moyenne),2);
    					ect = ect + ec;
    				}
    			}
    			equart = Math.sqrt(ect/compteur);
    			Arrays.sort(listenote);
    			md = compteur/2;
    			if(compteur%2 == 0) {
    				mediane = ((double)listenote[md-1]+(double)listenote[md])/2;
    			} else if (compteur%2 == 1){
    				mediane = listenote[md];
    			}
    			mode = Mode.mode(listenote);
    			notMat.add(new Notes(nom, moyenne));
    			infMat.add(new Info(nom, moyenne, mode, mediane, equart, compteur));
        		total = 0;
        		compteur = 0;
        		ec = 0;
        		ect = 0;
        		equart = 0;
        		nom = null;
        		notes.clear();
        		
        //System.out.println(evaMat);
    	}
    	
    }
    
}
