package com.servlet.test;

public class Professeur {

	int id_prof;
	String nom_prof;
	String prenom_prof;
	String statut_prof;
	String login_prof;
	String password_prof;
	
	/*Professeur(int id_prof, String nom_prof, String prenom_prof, String statut_prof, String login_prof){
		
	this.id_prof=id_prof;
	this.nom_prof=nom_prof;
	this.prenom_prof=prenom_prof;
	this.statut_prof=statut_prof;
	this.login_prof=login_prof;
	}

	Professeur get_Prof(String login){
		Professeur p = DB.getprofbylogin(login);
		return p;
	}*/
	
	Professeur(String login){
		Professeur p = BD.getprofbylogin(login);
		this.id_prof=p.id_prof;
		this.login_prof=login;
		this.nom_prof=p.nom_prof;
		this.prenom_prof=p.prenom_prof;
		this.password_prof=p.password_prof;
		this.statut_prof=p.statut_prof;
		
		
	}
	
}
