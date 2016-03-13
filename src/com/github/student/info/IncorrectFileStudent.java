package com.github.student.info;

public class IncorrectFileStudent extends Exception {

	@Override
	public String getMessage() {
		return "Input file of students is incorrect please follow the pattern: Student [firstName=Anna, lastName=Netreba, success=5.0, countOfAbsence=0];";
	}
	

}
