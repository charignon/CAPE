package com.servlet.test;

public class Cours {

	int id_cours;
	Professeur p;
	String module;
	String salle_cours;
	
	Cours(int id_cours, int id_prof){
		Cours c = BD.getcoursbyid(id_cours, id_prof);
		this.id_cours=c.id_cours;
		this.p=c.p;
		this.module=c.module;
		this.salle_cours=c.salle_cours;
		
	}
	
}
