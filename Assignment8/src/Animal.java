/**
 * 
 * @author Gopal
 * creating a base abstract class Animal
 *
 */
abstract public class Animal {
	private final String animalName;
	private final int animalAge;
	private final int animalWeight;
	private static int animalId;
	
	public Animal(String animalName, int age, int weight){
		this.animalName = animalName;
		this.animalAge = age;
		this.animalWeight = weight;
		animalId++;
	}
	abstract public void getDiscription();
	abstract public String getSound();
	public String getAnimalName(){
		return animalName;
	}
	
}


/**
 * 
 * @author Gopal
 * SubClass of Animal Mammal
 */
abstract class Mammel extends Animal{
	
	public Mammel(String animalName, int age, int weight){
		super(animalName,age,weight);
	}
	public void getDiscription(){
		System.out.println("They having 4 legs");
	}
	
}

class Lion extends Mammel {
	
	Lion(String animalName, int age, int weight){
		super(animalName,age,weight);
		
	}
	public String getSound(){
		return "Lion";
	}
}
class Tiger extends Mammel {
	
	Tiger(String animalName, int age, int weight){
		super(animalName,age,weight);
		
	}
	public String getSound(){
		return "Tiger";
	}
}


/**
 * 
 * @author Gopal
 * SubClass of Animal Reptile
 */

abstract class Reptile extends Animal{
	
	public Reptile(String animalName, int age, int weight){
		super(animalName,age,weight);
	
	}
	public void getDiscription(){
		System.out.println("They having no legs");
	}
	
}

class Snake extends Reptile{
	Snake(String animalName, int age, int weight){
		super(animalName, age , weight );
		
	}

	@Override
	public String getSound() {
		return "Snake";
	}
}
class Crocodile extends Reptile{
	Crocodile(String animalName, int age, int weight){
		super(animalName, age , weight );
		
	}

	@Override
	public String getSound() {
		return "Crocodile";
	}
}

/**
 * 
 * @author Gopal
 * SubClass of Animal Bird
 */

abstract class Bird extends Animal{
	
	public Bird(String animalName, int age, int weight){
		super(animalName,age,weight);
	}
	public void getDiscription(){
		System.out.println("They having no legs");
	}
	
}
class Peacock extends Bird{
	 Peacock(String animalName, int age, int weight){
		 super(animalName, age, weight);
	 }
	 
	@Override
	public String getSound() {
		return "Peacock";
	}
 }

class Eagle extends Bird{
	 Eagle(String animalName, int age, int weight){
		 super(animalName, age, weight);
	 }
	 
	@Override
	public String getSound() {
		return "Eagle";
	}
}