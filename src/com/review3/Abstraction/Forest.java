package com.review3.Abstraction;

import java.util.*;

public class Forest {
	public static void main(String[] args) {
		Apple a1 = new Apple("yellow");
		Fruit f1 = a1; // up-casting, implicit
		if (f1 instanceof Apple) { // I have to make sure that the fruit is of type Apple
			Apple a2 = (Apple) f1; // down-casting, explicit
		}

		Fruit apple = new Apple("red");
//		apple.eat();

		Fruit orange = new Orange("orange");
//		orange.eat();

		Fruit walnut = new Walnut("brown");
//		walnut.eat();

		List<Fruit> fruitBag = new ArrayList<>();
		fruitBag.add(apple);
		fruitBag.add(orange);
		fruitBag.add(walnut);

		for (Fruit fruit : fruitBag) {
			if (fruit instanceof Apple) {
				Apple a = (Apple) fruit;
				a.wash();
			} else if (fruit instanceof Orange) {
				Orange o = (Orange) fruit;
				o.peel();
			} else if (fruit instanceof Walnut) {
				Walnut w = (Walnut) fruit;
				w.crack();
			}

			fruit.eat();
			System.out.println();
		}

	}

}
