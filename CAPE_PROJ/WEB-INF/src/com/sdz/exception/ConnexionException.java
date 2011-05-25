package com.sdz.exception;

import javax.servlet.ServletException;

public class ConnexionException extends ServletException {

	public ConnexionException(){}
	public ConnexionException(String message){
		super(message);
	}	
}
