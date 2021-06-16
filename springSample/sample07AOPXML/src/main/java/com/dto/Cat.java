package com.dto;

public class Cat {
	
	private String name;
	private int age;
	private String color;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	public void info() {
		System.out.println("고양이 정보 출력~! 이름: " + name + "나이: "+ age + "색깔: "+color);
	}
	
	
}
