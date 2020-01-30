import java.util.HashMap;

public class Zone {

	String zoneCategory;
	int cageCounter=0;
	final int MAX_CAPACITY;
	HashMap<Integer, Cage> listOfCage = new HashMap<>();

	/**
	 * 
	 * @param category
	 * @param capacity
	 */
	public Zone(String category, int capacity) {
		this.zoneCategory = category;
		this.MAX_CAPACITY = capacity;

	}

	/**
	 * 
	 * @param animalBread
	 * @param animalCapacity
	 * @return true if cage added successfully
	 */
	public boolean addCage(Cage cage) {
		cageCounter++;
		
		if(!isSpaceAvaliable()){
			return false;
		}
		listOfCage.put(cageCounter, cage);
		return true;
		
	}

	/**
	 * 
	 * @param animalId
	 * @return true if cage removed successfully
	 */
	public boolean removeCage(int animalId){
		if(listOfCage.remove(animalId) != null){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if space available to add more cage
	 */
	public boolean isSpaceAvaliable(){
		if(MAX_CAPACITY >  listOfCage.size()){
			return true;
		}
		return false;
	}	
}