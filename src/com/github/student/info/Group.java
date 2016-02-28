package com.github.student.info;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group {
	private String groupName;
	private int groupNumber;
	private Student[] studentArray = new Student[10];

	public Group(String groupName, int groupNumber, Student[] studentArray) {
		super();
		this.studentArray = studentArray;
		this.groupName = groupName;
		this.groupNumber = groupNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Student[] getStudent() {
		return studentArray;
	}

	public void setStudent(Student[] studentArray) {
		this.studentArray = studentArray;
	}

	public void findStudent(String lastName) {
		String studentTemp = "";

		for (int i = 0; i < studentArray.length; i++) {

			if (studentArray[i].getLastName() == lastName) {
				studentTemp += studentArray[i] + "; ";
			}

		}
		System.out.println((studentTemp == "") ? "No such student" : "I've found: " + studentTemp);

	}

	public void addStudent(Student student) throws FullGroupException {
		if (studentArray.length < 10) {
			Student[] studentArrayTemp = new Student[studentArray.length + 1];
			System.arraycopy(studentArray, 0, studentArrayTemp, 0, studentArray.length);
			studentArrayTemp[studentArrayTemp.length - 1] = student;
			studentArray = studentArrayTemp;
			System.out.println("I've added to the group " + groupName + "-" + groupNumber + ": " + student.toString());
		} else
			throw new FullGroupException();
	}

	private boolean stringChecker(String str) {
		if (str.matches("[a-zA-Z]+$")) {
			return true;
		} else {
			return false;
		}
	}

	public void addStudent() throws FullGroupException, IncorrectInputException, IncorrectNameException {
		String str = JOptionPane.showInputDialog("Enter student's firstName and after coma lastName");
		if ((str == null) || (str.split(",").length != 2)) {
			throw new IncorrectInputException();
		} else {
			String[] strTemp = str.split(",");
			String firstName = strTemp[0];
			String lastName = strTemp[1];

			if (!stringChecker(firstName) || !stringChecker(lastName)) {
				throw new IncorrectNameException();
			} else {
				addStudent(new Student(firstName, lastName));
			}
		}

	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", groupNumber=" + groupNumber + ", studentArray="
				+ Arrays.toString(studentArray) + "]";
	}

}
