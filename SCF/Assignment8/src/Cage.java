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
	public boolean addAnimal(Animal animal) {
		
		animalCounter++;
		
		if(!isSpaceAvaliable()){
			return false;
		}
		listOfAnimal.put(animalCounter, animal);
		return true;
		
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