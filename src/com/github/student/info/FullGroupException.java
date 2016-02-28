package com.github.student.info;

public class FullGroupException extends Exception {

	@Override
	public String getMessage() {
		return "Group is Full. Please choose another one";
	}

}
