package com.john;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("commentaire")
	@Expose
	private String commentaire;
	@SerializedName("nom_evaluation")
	@Expose
	private String nomEvaluation;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("ponderation")
	@Expose
	private String ponderation;
	@SerializedName("donnees")
	@Expose
	private List<Donnee> donnees = null;

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getNomEvaluation() {
		return nomEvaluation;
	}

	public void setNomEvaluation(String nomEvaluation) {
		this.nomEvaluation = nomEvaluation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPonderation() {
		return ponderation;
	}

	public void setPonderation(String ponderation) {
		this.ponderation = ponderation;
	}

	public List<Donnee> getDonnees() {
		return donnees;
	}

	public void setDonnees(List<Donnee> donnees) {
		this.donnees = donnees;
	}

}