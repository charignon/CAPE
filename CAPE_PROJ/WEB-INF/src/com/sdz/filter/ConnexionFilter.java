package com.sdz.filter;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.Bd;

public class ConnexionFilter implements Filter{

	private FilterConfig config;
	private Bd bd;

	
	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Contrôle des identifiants de connexion.");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
	
		//On contrôle l'existence de la session
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("login") != null && session.getAttribute("password") != null){
			//Si on a des données en session, c'est qu'on est connecté
			try {
				String ret = bd.isProf(session.getAttribute("login").toString(),session.getAttribute("password").toString());
				if (!ret.equals("false"))
				{
					request.setAttribute("nom", ret);
					chain.doFilter(request, response);
				}
				else
				request.getRequestDispatcher("/connexion.jsp").forward(request, response);
					
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		}
		else{

		
			
			//On vérifie ensuite si on a pas de formulaire de connexion validé 
			if(login != null && password != null){
				//Si on a des données en session, c'est qu'on est connecté
				System.out.println("Il y a des données : " + login + " - " + password + " !");
				
				
				if(login.trim().equals("") || password.trim().equals("")) {
					throw new com.sdz.exception.ConnexionException("Vous devez renseigner au moins l'un des champs du formulaire");					
				}
			
				try {
					String ret = bd.isProf(login, password);
					if (!ret.equals("false"))
					{
					request.setAttribute("nom", ret);
					chain.doFilter(request, response);
					}
					else
					request.getRequestDispatcher("/connexion.jsp").forward(request, response);
						
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
				
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
		bd = new Bd();
		
	}

}
