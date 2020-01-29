import java.util.HashMap;

public class Zoo {
	final String zooName;
	int zoneCounter=0;
	final int MAX_CAPACITY;
	HashMap<Integer, Zone> listOfZone = new HashMap<>();

	/**
	 * 
	 * @param zooName
	 * @param capacity
	 */
	public Zoo(String zooName,int capacity) {
		this.zooName = zooName;
		this.MAX_CAPACITY = capacity;

	}

	
	/**
	 * 
	 * @param animalCategory
	 * @param animalCapacity
	 * @return true if zone is added Successfully
	 */
	public boolean addZone(String animalCategory, int animalCapacity) {
		zoneCounter++;
		
		if(!isSpaceAvaliable()){
			return false;
		}
		Zone zone = new Zone(animalCategory, animalCapacity);
		listOfZone.put(zoneCounter, zone);
		return true;
		
	}

	/**
	 * 
	 * @param animalId
	 * @return true if zone is removed successfully
	 */
	public boolean removeZone(int animalId){
		if(listOfZone.remove(animalId) != null){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if zone space available
	 */
	public boolean isSpaceAvaliable(){
		if(MAX_CAPACITY >  listOfZone.size()){
			return true;
		}
		return false;
	}	
}