package com.servlet.test;

public class Attention {

	int id_attention;
	Cours c;
	String fichier_image;
	String fichier_log;
	
	Attention(int id_cours, int id_attention){
		Attention a=BD.getattentionbyid(id_cours, id_attention);
		this.id_attention=a.id_attention;
		this.c=a.c;
		this.fichier_image=a.fichier_image;
		this.fichier_log=a.fichier_log;
		
	}
	
}