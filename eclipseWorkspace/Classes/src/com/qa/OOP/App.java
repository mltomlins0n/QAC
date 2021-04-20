package com.qa.OOP;

import java.util.ArrayList;

public class App {
	public static Encapsulation secret = new Encapsulation();
	public static void main(String[] args) {
		// Initialise instance of class to run methods
		// Avoids using static methods everywhere
		App app = new App();
		//app.threeCats();
		//app.twoCatsOneMemory();
		//app.dogs();
		//app.secret.setSecret("lol");
		//app.printSecret();
		//app.createPenguin();
		//app.createRockHopper();
		//app.vehicles();
		//app.overloadedCats();
		//app.overriddenCats();
		//app.animalSpeak();
		//app.animalEat();
		//app.createAnimal();
		//app.createBox();
		//app.createPerson();
	}
	
	public void threeCats() {
        Cat kitty = new Cat("=(^O.o^)=", 3);
		
		kitty.fur = "Ginger";
		
		Cat kitty2 = new Cat("Alvina", 4);
		
		kitty2.fur = "Grey";
		
		Cat kitty3 = new Cat("Salem", 2);
		
		kitty3.fur = "Black";
		
		// calls toString()
		System.out.println(kitty);
		System.out.println(kitty2);
		System.out.println(kitty3);
		
		/*// toString method does this
		System.out.println("Kitty");
		System.out.println("Name: " + kitty.name);
		System.out.println("Colour: " + kitty.fur);
		System.out.println("Lives: " + kitty.lives);
		
		System.out.println("Kitty 2");
		System.out.println("Name: " + kitty2.name);
		System.out.println("Colour: " + kitty2.fur);
		System.out.println("Lives: " + kitty2.lives);
		
		System.out.println("Kitty 3");
		System.out.println("Name: " + kitty3.name);
		System.out.println("Colour: " + kitty3.fur);
		System.out.println("Lives: " + kitty3.lives);
		*/
	}
	
	public void twoCatsOneMemory() {
		Cat meowser = new Cat(2);
		Cat catDamon = meowser;
		
		System.out.println(meowser);
		System.out.println(catDamon);
		
		meowser.name = "Shakespaw";
		
		System.out.println(catDamon.name);
	}
	
	public void dogs() {
		Dog doggo1 = new Dog("Sif", "Grey");
		Dog doggo2 = new Dog("Dany", "White");
		Dog doggo3 = new Dog("Drogo", "Black");
		
		System.out.println("Name: " + doggo1.name + " Colour: " + doggo1.colour);
		System.out.println("Name: " + doggo2.name + " Colour: " + doggo2.colour);
		System.out.println("Name: " + doggo3.name + " Colour: " + doggo3.colour);
	}
	
	public void printSecret() {
		// Call the public getter
    	System.out.println(secret.getSecret());
    }
	
	public void createPenguin() {
		Penguin pingu = new Penguin("Very fluffy");
		pingu.eat();
		pingu.speak();
		pingu.sleep();
		pingu.swim();
	}
	
	public void createRockHopper() {
		RockHopper pingu = new RockHopper("Very fluffy", "Hopping");
		System.out.println(pingu.fluffiness);
		System.out.println(pingu.hopping);
	}
	
	public void vehicles() {
		Car citroenC2 = new Car(1, "Citroen C2", 4);
		
		System.out.println(citroenC2.getId());
		System.out.println(citroenC2.getName());
		
		Car civicTypeR = new Car(2, "Honda Civic Type R", 4);
		
		System.out.println(civicTypeR.getId());
		System.out.println(civicTypeR.getName());
		
		Car alfaBrera = new Car(3, "Alfa Romeo Brera", 4);
		
		System.out.println(alfaBrera.getId());
		System.out.println(alfaBrera.getName());
		
		Hovercraft hover1 = new Hovercraft(4, "Hovercraft 1 ", 300);
		
		Vehicle veh1 = (Vehicle) citroenC2; // Cast to vehicle
		Vehicle veh2 = (Vehicle) civicTypeR;
		Vehicle veh3 = (Vehicle) hover1;
		//System.out.println(veh1.getWheels()); // Class Vehicle has no attribute "wheels"
        
		// Declare ArrayList and add vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        vehicles.add(veh1);
        vehicles.add(veh2);
        vehicles.add(veh3);
        
        // Loop through ArrayList and print details
        for (Vehicle veh : vehicles) {
        	if (veh instanceof Car) {
        		Car car = (Car) veh;
            	System.out.println(car.getId());
            	System.out.println(car.getName());
            	System.out.println(car.getWheels());
        	}
        	else if (veh instanceof Hovercraft) {
        		Hovercraft hover = (Hovercraft) veh;
            	System.out.println(hover.getId());
            	System.out.println(hover.getName());
            	System.out.println(hover.getHp());
        	}
        }
        
        /*
        Car car1 = (Car) vehicles.get(0);
        Car car2 = (Car) vehicles.get(1);
        
        System.out.println(car1.getId());
        System.out.println(car1.getName());
        System.out.println(car1.getWheels());
        
        System.out.println(car2.getId());
        System.out.println(car2.getName());
        System.out.println(car2.getWheels());
		*/
	}
	
	public void overloadedCats() {
		Cat kitty = new Cat("=(^O.o^)=", 3);
		Cat stray = new Cat(6);
		
		System.out.println(kitty.getName());
		System.out.println(kitty.getAge());
		
		stray.setName("Purrcy");
		
		System.out.println(stray.getName());
		System.out.println(stray.getAge());
	}
	
	public void overriddenCats() {
		Animal kitty = new Cat("=(^o.o^)=", 3);
		
		kitty.speak(); // Calls method from class Cat
		
	}
	
	public void animalSpeak() {
		Animal kitty = new Cat("=(^o.o^)=", 3);
		Animal doggo = new Dog("Sif", "Grey");
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		animals.add(kitty);
		animals.add(doggo);
		
		for (Animal a : animals) {
			a.speak();
		}
	}
	
	public void animalEat() {
		Animal kitty = new Cat("=(^o.o^)=", 3);
		Animal doggo = new Dog("Sif", "Grey");
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		animals.add(kitty);
		animals.add(doggo);
		
		for (Animal a : animals) {
			a.eat();
		}
	}

	public void createAnimal() {
		Bird bird = new Bird();
		// Cast to interface types
		FlyingCreature flyBoi = (FlyingCreature) bird;
		HairyCreature hairyBoi = (HairyCreature) bird;
		
		flyBoi.fly();
		hairyBoi.preen();
	}
	
	public void createBox() {
		Box box = new Box();
		Box box2 = new Box();
		
		box.colour = "Purple";
		box.item = "Cat";
		
		// Accesses the instances to print
		System.out.println(box);
		System.out.println(box2);
		
		// Accesses the class to print
		System.out.println(Box.colour);
		System.out.println(Box.item);
		
	}
	
	public void createPerson() {
		Person p = new Person("Martin", 28);
		Person p2 = new Person("Mohammed", 23);
		Person p3 = new Person("Dylan", 21);
		
		for (Person person : Person.people) {
			System.out.println(person);
		}
		
	}
}
