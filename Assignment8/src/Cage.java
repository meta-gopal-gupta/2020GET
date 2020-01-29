import java.util.HashMap;

public class Cage {

	String animalBreed;
	int animalCounter=0;
	final int MAX_CAPACITY;
	HashMap<Integer, Animal> listOfAnimal = new HashMap<>();

	/**
	 * 
	 * @param animalBread
	 * @param capacity
	 */
	public Cage(String animalBread, int capacity) {
		this.animalBreed = animalBread;
		this.MAX_CAPACITY = capacity;

	}

	/**
	 * 
	 * @param type
	 * @param animalName
	 * @param animalAge
	 * @param animalWeight
	 * @return true if animal add successfully 
	 */
	public boolean addAnimal(String type, String animalName, int animalAge,int animalWeight) {
		
		animalCounter++;
		
		if(!isSpaceAvaliable()){
			return false;
		}
		
		Animal animal = null;
		if ("Lion".equalsIgnoreCase(type)) {
			animal = new Eagle(animalName, animalAge, animalWeight);
		}

		if ("Tiger".equalsIgnoreCase(type)) {
			animal = new Tiger(animalName, animalAge, animalWeight);
		}

		if ("Peacock".equalsIgnoreCase(type)) {
			animal = new Peacock(animalName, animalAge, animalWeight);
		}

		if ("Eagle".equalsIgnoreCase(type)) {
			animal = new Eagle(animalName, animalAge, animalWeight);
		}

		if ("Snake".equalsIgnoreCase(type)) {
			animal = new Snake(animalName, animalAge, animalWeight);
		}
		if ("Crocodile".equalsIgnoreCase(type)) {
			animal = new Crocodile(animalName, animalAge, animalWeight);
		}
		if(animal != null){
			listOfAnimal.put(animalCounter, animal);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param animalId
	 * @return true if animal is removed successfully
	 */
	public boolean removeAnimal(int animalId){
		if(listOfAnimal.remove(animalId) != null){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if space available to add more animal
	 */
	public boolean isSpaceAvaliable(){
		if(MAX_CAPACITY >  listOfAnimal.size()){
			return true;
		}
		return false;
	}	
}