package com.github.student.info;

public class Human {
	private String firstName;
	private String lastName;
	private int age;
	private double weight;
	private boolean sex;
	private String temperament;

	public Human(String firstName, String lastName, int age, double weight, boolean sex, String temperament) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weight = weight;
		this.sex = sex;
		this.temperament = temperament;
	}

	public Human(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Human() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	@Override
	public String toString() {
		return "Human [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", weight=" + weight
				+ ", sex=" + sex + ", temperament=" + temperament + "]";
	}

}
