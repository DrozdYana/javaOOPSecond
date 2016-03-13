package com.github.student.info;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements Serializable{
	private String groupName;
	private int groupNumber;
	private Student[] studentArray = new Student[10];
	private static final long serialVersionUID = 1L;

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

	public void writeInFile(Student[] studentArrayResult,String fileName) {

		try (PrintWriter pr = new PrintWriter(fileName)) {
			for (Student student : studentArrayResult) {
				pr.println(student.toString());
			}

		} catch (FileNotFoundException ex) {
			System.out.println("ERROR WHILE FILE WRITING!!!");
		}

	}

	public void readFromFile(String fileName) throws IncorrectFileStudent, FullGroupException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String lineSeparator = System.getProperty("line.separator");
			String line = "";

			System.out.println();
			for (; (line = reader.readLine()) != null;) {
				sb.append(line);
				sb.append(lineSeparator);
			}
		} catch (Exception ex) {
			System.out.println();
			System.out.println("Wasn't able to read file");

		}

		String[] strArray = sb.toString().split("\n");
		String[] strArrayCorrect = new String[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].startsWith("Student")) {
				strArrayCorrect[i] = strArray[i].replaceAll("Student \\[", "").replaceAll("\\]", "");
				if (strArrayCorrect[i].contains("firstName") && strArrayCorrect[i].contains("lastName")
						&& strArrayCorrect[i].contains("success") && strArrayCorrect[i].contains("countOfAbsence")) {
					String firstName = strArrayCorrect[i].substring(strArrayCorrect[i].indexOf("firstName=") + 10,
							strArrayCorrect[i].indexOf(", lastName"));

					String lastName = strArrayCorrect[i].substring(strArrayCorrect[i].indexOf("lastName=") + 9,
							strArrayCorrect[i].indexOf(", success"));

					String success = strArrayCorrect[i].substring(strArrayCorrect[i].indexOf("success=") + 8,
							strArrayCorrect[i].indexOf(", countOfAbsence"));
					String countOfAbsence = strArrayCorrect[i]
							.substring(strArrayCorrect[i].indexOf("countOfAbsence=") + 15);

					addStudent(new Student(firstName, lastName, Double.parseDouble(success),
							Integer.parseInt(countOfAbsence)));

				} else {
					throw new IncorrectFileStudent();
				}

			} else {
				throw new IncorrectFileStudent();
			}
		}

	}

	public void writeAnObjectStudent(Student[] studentArrayResult, String fileName) {
		Group group=new Group(this.groupName,this.groupNumber,studentArrayResult);
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
			output.writeObject(group);
		} catch (IOException e) {
			System.out.println("Can't save group to a file !!!");
		}
	}

	public Group readAnObjectStudent(String fileName) {
		Group group=new Group(this.groupName,this.groupNumber,null);
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
			
			group = (Group) input.readObject();
			
			this.setStudent(studentArray);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Can't read a Group from file");
		}
		return group;
	}

}
