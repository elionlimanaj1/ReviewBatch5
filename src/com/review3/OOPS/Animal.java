package com.review3.OOPS;

public class Animal {
	String name;
	int legs;

	public Animal(String name, int legs) {
		// super();
		this.name = name;
		this.legs = legs;
	}

	public void talk() {
		System.out.println("Animal is talking");
	}

	public void talk(String word) {
		System.out.println("Animal says " + word);
	}

	public void talk(String word, int times) {
		System.out.print("Animal says");
		for (int i = 1; i <= times; i++) {
			System.out.print(" " + word);
		}
		System.out.println();
	}
}

class Dog extends Animal {
	String breed;

	public Dog(String name, int legs) {
		super(name, legs);
	}

	public Dog(String name, int legs, String breed) {
		this(name, legs);
		this.breed = breed;
	}
	
	@Override
	public void talk() {
		System.out.println("Dog says woof");
	}

}

class Cat extends Animal{
	public Cat(String name, int legs) {
		super(name, legs);
	}
	
	@Override
	public void talk() {
		System.out.println("Cat says meow");
	}
	
}

//class Cow extends Animal{
//	
//}