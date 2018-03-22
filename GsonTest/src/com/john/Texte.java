package com.john;

import java.util.ArrayList;
import java.util.Arrays;

public class Texte {
	
	static int in;
	static EtudiantCode [] etud = new EtudiantCode[FolderReadListe.eBio.length];
	static EtudiantCode [] etudm = new EtudiantCode[FolderReadListe.eMat.length];
	static ArrayList<NoteEva> temp = new ArrayList<>();
	static ArrayList<NoteMoyenne> moyBio = new ArrayList<>();
	static ArrayList<NoteMoyenne> moyMat = new ArrayList<>();
	
	public static void textBio() {
		
		Evaluation[] evaluationBio = FolderReadBio.evaBio.toArray(new Evaluation[FolderReadBio.evaBio.size()]);
		
		Evaluation[] evaluationMat = FolderReadMat.evaMat.toArray(new Evaluation[FolderReadMat.evaMat.size()]);
		
		Notes[] notesBio = FolderReadBio.notBio.toArray(new Notes[FolderReadBio.notBio.size()]);
		
		Notes[] notesMat = FolderReadMat.notMat.toArray(new Notes[FolderReadMat.notMat.size()]);
		
		
		for(int y = 0; y < evaluationBio.length; y++) {
			
			for(int z = 0; z < notesBio.length; z++) {
				
				if(notesBio[z].nom.equals(evaluationBio[y].nomEval)) {
					
					moyBio.add(new NoteMoyenne(evaluationBio[y].code, evaluationBio[y].nomEval, evaluationBio[y].ponderation, evaluationBio[y].note, notesBio[z].moyenne));
				}
			}
		}
		
		NoteMoyenne[] noteMoyenneBio = moyBio.toArray(new NoteMoyenne[moyBio.size()]);
		
		for(int d = 0; d < FolderReadListe.eBio.length; d++) {
			
			for(int x = 0; x < noteMoyenneBio.length; x++) {
				
				if(noteMoyenneBio[x].code.equals(FolderReadListe.eBio[d].code)) {
					
					temp.add(new NoteEva(noteMoyenneBio[x].nomEva, noteMoyenneBio[x].ponderation, noteMoyenneBio[x].note, noteMoyenneBio[x].moyenne));
				}
			}
			
			etud[d] = new EtudiantCode(FolderReadListe.eBio[d].nom, FolderReadListe.eBio[d].prenom, FolderReadListe.eBio[d].code, (ArrayList<NoteEva>)temp.clone());
			temp.clear();

		}

		for(int t = 0; t < etud.length; t++) {
			
			
		}
		
}
	
	public static void textMat () {
		
		Evaluation[] evaluationMat = FolderReadMat.evaMat.toArray(new Evaluation[FolderReadMat.evaMat.size()]);
		
		Notes[] notesMat = FolderReadMat.notMat.toArray(new Notes[FolderReadMat.notMat.size()]);
		
		
		for(int y = 0; y < evaluationMat.length; y++) {
			
			for(int z = 0; z < notesMat.length; z++) {
				
				if(notesMat[z].nom.equals(evaluationMat[y].nomEval)) {
					
					moyMat.add(new NoteMoyenne(evaluationMat[y].code, evaluationMat[y].nomEval, evaluationMat[y].ponderation, evaluationMat[y].note, notesMat[z].moyenne));
				}
			}
		}
		
		NoteMoyenne[] noteMoyenneMat = moyMat.toArray(new NoteMoyenne[moyMat.size()]);
		
		for(int d = 0; d < FolderReadListe.eMat.length; d++) {
			
			for(int x = 0; x < noteMoyenneMat.length; x++) {
				
				if(noteMoyenneMat[x].code.equals(FolderReadListe.eMat[d].code)) {
					
					temp.add(new NoteEva(noteMoyenneMat[x].nomEva, noteMoyenneMat[x].ponderation, noteMoyenneMat[x].note, noteMoyenneMat[x].moyenne));
				}
			}
			
			etudm[d] = new EtudiantCode(FolderReadListe.eMat[d].nom, FolderReadListe.eMat[d].prenom, FolderReadListe.eMat[d].code, (ArrayList<NoteEva>)temp.clone());
			temp.clear();

		}

		for(int t = 0; t < etudm.length; t++) {
			
			
		}
		
	}
	
}
