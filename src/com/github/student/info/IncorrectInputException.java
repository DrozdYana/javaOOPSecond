package com.github.student.info;


public class IncorrectInputException extends Exception {

	@Override
	public String getMessage() {
		return "You haven't followed the recomendations so student wasn't added to the group";
	}
	

}
