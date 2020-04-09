package com.review3.Polymorphism;

public class Barn {
	
	public static void main(String[] args) {
		Animal animal1 = new Cat("John", 4);
		
		Animal animal2 = new Dog("James", 4, "Bulldog");
//		animal2.talk();
//		animal2.talk("woof");
//		animal2.talk("woof", 5);
		
		animal1.talk();
		animal2.talk();	
	}

}
