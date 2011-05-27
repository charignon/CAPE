package com.sdz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConnexionFilter implements Filter{

	private FilterConfig config;
	
	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Contrôle des identifiants de connexion.");
		
		//On contrôle l'existence de la session
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("login") != null && session.getAttribute("password") != null){
			//Si on a des données en session, c'est qu'on est connecté
			chain.doFilter(request, response);
		}
		else{

			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			//On vérifie ensuite si on a pas de formulaire de connexion validé 
			if(login != null && password != null){
				//Si on a des données en session, c'est qu'on est connecté
				System.out.println("Il y a des données : " + login + " - " + password + " !");
				
				
				if(login.trim().equals("") || password.trim().equals("")) {
					throw new com.sdz.exception.ConnexionException("Vous devez renseigner au moins l'un des champs du formulaire");					
				}
			
				chain.doFilter(request, response);
				
				
			}
			else{
				//Sinon, on retourne à la page de connexion
				System.out.println("Pas de session, on oriente donc vers la page de connexion.");
				request.getRequestDispatcher("/connexion.jsp").forward(request, response);
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
