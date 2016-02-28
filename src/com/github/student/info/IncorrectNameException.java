package com.github.student.info;

import javax.swing.JOptionPane;

public class IncorrectNameException extends Exception {

	@Override
	public String getMessage() {
		return "Correct name and last name (MUST BE ONLY LETTERS!!!)";
	}
	

}
