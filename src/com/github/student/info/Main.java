package com.github.student.info;

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

		Student[] studentArray = { studentOne, studentTwo, studentThree, studentFour, studentFive, studentSix,
				studentSeven, studentEight, studentNine };
		Group groupOne = new Group("KA", 81, studentArray);
		groupOne.findStudent("Petrov");
		groupOne.findStudent("Netreba");
		groupOne.findStudent("Kotov");
		try {
			groupOne.addStudent(studentTen);
			groupOne.addStudent(studentEleven);
		} catch (FullGroupException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(groupOne.toString());

	}

}
