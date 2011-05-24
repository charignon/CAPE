package com.servlet.test;

public class Question {

	int id_question;
	Cours c;
	int A,B,C,D;
	
	Question(int id_cours, int id_question){
		Question q = BD.getquestionbyid(id_cours,id_question);
		this.id_question=q.id_question;
		this.c=q.c;
		this.A=q.A;
		this.B=q.B;
		this.C=q.C;
		this.D=q.D;
		
	}
	
}
