package com.servlet.test;

public class Eleve {

	int id_eleve;
	int id_cours;
	String login_eleve;
	String password_eleve;
	
	Eleve(String login){
		Eleve e = BD.getelevebylogin(login);
		this.id_eleve=e.id_eleve;
		this.id_cours=e.id_cours;
		this.login_eleve=login;
		this.password_eleve=e.password_eleve;
	}
	
}
