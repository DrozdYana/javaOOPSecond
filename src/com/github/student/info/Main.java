package com.github.student.info;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Student studentOne = new Student("Ivan", "Ivanov", 3.5, 15);
		Student studentTwo = new Student("Petro", "Petrov", 3.8, 10);
		Student studentThree = new Student("Evgen", "Petrov", 4.0, 5);
		Student studentFour = new Student("Olena", "Petrova", 4.0, 3);
		Student studentFive = new Student("Ihor", "Coval", 4.2, 2);
		Student studentSix = new Student("Iryna", "Coval", 4.6, 1);
		Student studentSeven = new Student("Aleksandr", "Pushkin", 4.3, 2);
		Student studentEight = new Student("Phedor", "Frolov", 3.2, 17);
		Student studentNine = new Student("Anna", "Netreba", 5.0, 0);
		Student studentTen = new Student("Semen", "Slepakov", 3.9, 8);
		Student studentEleven = new Student("Kamila", "Streltsova", 4.0, 3);
		
		ArrayList<Student> studentList=new ArrayList<>();
		studentList.add(studentOne);
		studentList.add(studentTwo);
		studentList.add(studentThree);
		studentList.add(studentFour);
		studentList.add(studentFive);
		studentList.add(studentSix);
		studentList.add(studentSeven);
		studentList.add(studentEight);
		studentList.add(studentNine);
		studentList.add(studentTen);
		studentList.add(studentEleven);
		
		ArrayList<Student> studentArray=new ArrayList<>();
		studentArray.add(studentOne);
		studentArray.add(studentTwo);
		studentArray.add(studentThree);
		studentArray.add(studentFour);
		studentArray.add(studentFive);
		studentArray.add(studentSix);
		studentArray.add(studentSeven);
		studentArray.add(studentEight);
		studentArray.add(studentNine);
		
		Group groupOne = new Group("KA", 81, studentArray);
		groupOne.findStudent("Petrov");
		groupOne.findStudent("Netreba");
		groupOne.findStudent("Kotov");
		/* Write in file */
		groupOne.writeInFile(studentArray,"GroupOutput.txt");
		ArrayList<Student> studentArrayTwo=new ArrayList<>();
		Group groupTwo = new Group("KA", 82, studentArrayTwo);
		try {
			groupOne.addStudent(studentTen);

			int confirm = (JOptionPane.showConfirmDialog(null, "Would you like to add more students to the group",
					"Question", JOptionPane.YES_NO_OPTION));
			while (confirm == JOptionPane.YES_OPTION) {
				groupTwo.addStudent();
				confirm = (JOptionPane.showConfirmDialog(null, "Would you like to add more students to the group",
						"Question", JOptionPane.YES_NO_OPTION));
			}
			groupOne.addStudent(studentEleven);
		} catch (FullGroupException | IncorrectInputException | IncorrectNameException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(groupOne.toString());
		System.out.println(groupTwo.toString());
		ArrayList<Student> studentArrayGroup = groupOne.getStudent();
		System.out.println("FINAL ARRAY" + studentArrayGroup);
		
		System.out.print("Group journal: ");
		for (Student student : studentArrayGroup) {
			System.out.print(student.getLastName() + "; ");
		}
		ArrayList<Student> studentArrayThree=new ArrayList<>();
		Group groupThree = new Group("KA", 82, studentArrayThree);
		try {
			groupThree.readFromFile("GroupInput.txt");
		} catch (IncorrectFileStudent | FullGroupException e) {
			e.getMessage();
		}
		
		Group groupFour=new Group("KA", 83, null);
		ArrayList<Student> studentArrayFour=new ArrayList<>();
		studentArrayFour.add(studentOne);
		studentArrayFour.add(studentTwo);
		studentArrayFour.add(studentThree);
				
		groupFour.writeAnObjectStudent(studentArrayFour, "NewOutGroup.txt");
		Group groupFive=new Group(null, 0, null);
		groupFive=groupFive.readAnObjectStudent("NewOutGroup.txt");
		System.out.println(groupFive);

	}

}
