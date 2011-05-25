package com.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

public class Processor {

	String cours;
	ArrayList <String> already_answered;
	//Temporary answer
	int a=0;
	int b=0;
	int c=0;
	int d=0;
	int mode=0; // 0 = no question at the moment, 1 = processing a question
	
	Processor(String cours)
	{
		this.cours = cours;
		already_answered = new ArrayList<String>();
	
	}
	
	public String getSummary()
	{
		this.mode = 0;	
		return "a="+a+",b="+b+",c"+c+",d="+d;
		
	}
	
	public void new_question()
	{
		this.already_answered.clear();
		this.mode=1;
	}
	
	
	public String processStudentAnswer( HttpServletRequest request)
	{
		//If there is no question at the moment 
		if (mode == 0 )
			return "No question at the moment !";
		//If there is a pending question
		else
		{
		
			//We can assume that the user is authenticated since we used a filter
			HttpSession session = request.getSession();
			String id = session.getId();
			//If the user has not a valid session
			if (id=="")
			{
				System.out.println("ID VIDE !!!!");
				return "Wrong session parameters";
			}
			String answer = (String)request.getParameter("answer");
		
			//If the user as already answered to this question
			if (already_answered.contains(id))
				return "Already answered";
		
			//We can assume that the student tries to answer to a question he didn't attempt before.
			if (answer.contains("a"))
				this.a++;
			if (answer.contains("b"))
				this.b++;
			if (answer.contains("c"))
				this.c++;
			if (answer.contains("d"))
				this.d++;
			if (answer.contains("d") | answer.contains("c") | answer.contains("b") | answer.contains("a"))
				this.already_answered.add(id);
			return "Everything was correct, answer acquired";
		}	
		
		
		
		
	}
	
}
