package com.review3.Abstraction;

public abstract class Fruit {
	String color;

	public Fruit(String color) {
		this.color = color;
	}

	public abstract void eat(); 
	// it is not implemented, we have abstraction
	// if it was implemented, we would have polymorphism
}

class Apple extends Fruit implements Peelable, Washable {

	public Apple(String color) {
		super(color);
	}

	@Override
	public void eat() {
		//wash();
		System.out.println("Eating and apple");
	}

	@Override
	public void peel() {
		System.out.println("First peel the apple");
	}

	@Override
	public void wash() {
		System.out.println("Wash the apple");
	}
}

class Orange extends Fruit implements Peelable {
	public Orange(String color) {
		super(color);
	}

	@Override
	public void peel() {
		System.out.println("Peel the orange");
	}

	@Override
	public void eat() {
		//peel();
		System.out.println("Eat the orange");
	}
}

class Walnut extends Fruit implements Crackable {

	public Walnut(String color) {
		super(color);
	}

	@Override
	public void crack() {
		System.out.println("First we crack the walnut");
	}

	@Override
	public void eat() {
		//crack();
		System.out.println("Eating walnut");
	}

}