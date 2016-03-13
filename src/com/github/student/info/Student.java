package com.github.student.info;

import java.io.Serializable;

public class Student extends Human implements Comparable,Serializable {
	private double success;
	private int countOfAbsence;
	private static final long serialVersionUID = 1L;

	public Student(String firstName, String lastName, double success, int countOfAbsence) {
		super(firstName, lastName);
		this.success = success;
		this.countOfAbsence = countOfAbsence;
	}

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Student() {
		super();
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
	public int compareTo(Object object) {
		Student student = (Student) object;
		/*
		 * May be one of the variants: if (this.getLastName().length() >
		 * student.getLastName().length()) { return 1; } else if
		 * (this.getLastName().length() < student.getLastName().length()) {
		 * return -1; }
		 */
		int compare = this.getLastName().compareToIgnoreCase(student.getLastName());
		if (compare != 0) {
			return compare;
		} else
			return 0;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", success=" + success
				+ ", countOfAbsence=" + countOfAbsence + "]";
	}

}
