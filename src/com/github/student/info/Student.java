package com.github.student.info;

public class Student extends Human {
	private double success;
	private int countOfAbsence;

	public Student(String firstName, String lastName, double success, int countOfAbsence) {
		super(firstName, lastName);
		this.success = success;
		this.countOfAbsence = countOfAbsence;
	}

	public double getSuccess() {
		return success;
	}

	public void setSuccess(double success) {
		this.success = success;
	}

	public double getCountOfAbsence() {
		return countOfAbsence;
	}

	public void setCountOfAbsence(int countOfAbsence) {
		this.countOfAbsence = countOfAbsence;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + getFirstName() + ", lastName=" + getLastName() + " success=" + success
				+ ", countOfAbsence=" + countOfAbsence + "]";
	}

}
