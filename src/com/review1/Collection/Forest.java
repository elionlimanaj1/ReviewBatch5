package com.review1.Collection;

import java.util.*;

public class Forest {
	public static void main(String[] args) {
		List<Dog> dogList = new ArrayList<>();

		Dog d1 = new Dog();
		Dog d2 = new Dog();

		Cat c1 = new Cat();
		Cat c2 = new Cat();

		Snake s1 = new Snake();
		Snake s2 = new Snake();

		dogList.add(d1);
		dogList.add(d2);
		dogList.add(new Dog());
		// cannot add a cat into a list of dogs
		// dogList.add(c1);

		for (Dog d : dogList) {
			// get the dog and do whatever you want
		}

		List<Animal> animalList = new ArrayList<>();
		animalList.add(d1);
		animalList.add(c2);
		animalList.add(s1);

		for (Animal animal : animalList) {
			// get the animal and do whatever you want
			animal.sleep();

			// You have to check for the conversion/casting
			// Dog doggie = (Dog) animal;
			if (animal instanceof Dog) {
				Dog dog = (Dog) animal;
				dog.bark();
			} else if (animal instanceof Cat) {
				Cat cat = (Cat) animal;
				cat.meow();
			}
			System.out.println();
		}

	}
}
