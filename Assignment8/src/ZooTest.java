import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTest {

	
	

	@Test
	public void addAnimalInCageMoreThenCapacityTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal("Lion", "Lion1", 9, 30);
		assertEquals(true, isAdded);
		
		isAdded = cage.addAnimal("Lion", "Lion2", 12, 32);
		assertEquals(true, isAdded);
		
		isAdded = cage.addAnimal("Lion", "Lion3", 13, 33);
		assertEquals(false, isAdded);
		
		// Animal adding after Max Capacity
		isAdded = cage.addAnimal("Lion", "Lion4", 13, 33);
		assertEquals(false, isAdded);
		
		//Remove Animal
		boolean isRemoved = cage.removeAnimal(4);
		assertEquals(false, isRemoved);
		
		//Remove Animal
		isRemoved = cage.removeAnimal(2);
		assertEquals(true, isRemoved);

		isAdded = cage.addAnimal("Lion", "Lion4", 13, 33);
		assertEquals(true, isAdded);		
	}
	
	@Test
	public void addAnimalInCageNegativeTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal("Wrong", "Lion1", 9, 30);
		assertEquals(false, isAdded);
			
	}
	
	@Test
	public void addAnimalAndretriveAnimalDataCageTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal("Lion", "Lion1", 9, 30);
		assertEquals(true, isAdded);
		
		String animalName = cage.listOfAnimal.get(1).getAnimalName();
		assertEquals("Lion1",animalName);
		
	}
	

	@Test
	public void addCageInZoneMoreThenCapacityTestCase(){
		Zone zone = new Zone("Mammel" , 2);
		boolean isAdded = zone.addCage("Carnivore",2);
		assertEquals(true, isAdded);
		
		isAdded = zone.addCage("Carnivore",3);
		assertEquals(true, isAdded);
		
		isAdded = zone.addCage("Herbiores",4);
		assertEquals(false, isAdded);
		
		//Remove Cage with wrong cageID
		boolean isRemoved = zone.removeCage(4);
		assertEquals(false, isRemoved);
		
		
		//Remove Cage with Correct cageID
		isRemoved = zone.removeCage(1);
		assertEquals(true, isRemoved);
		
		int availableCage = zone.listOfCage.size();
		assertEquals(1,availableCage);
			
	}
	
	

	@Test
	public void addZoneInZooMoreThenCapacityTestCase(){
		Zoo zoo = new Zoo("National Zoo" , 2);
		boolean isAdded = zoo.addZone("Mammel", 5);
		assertEquals(true, isAdded);
		
		isAdded = zoo.addZone("Reptile", 3);
		assertEquals(true, isAdded);
		
		isAdded = zoo.addZone("Bird", 7);
		assertEquals(false, isAdded);
		
		//Remove Zone with wrong cageID
		boolean isRemoved = zoo.removeZone(4);
		assertEquals(false, isRemoved);
		
		
		//Remove Cage with Correct cageID
		isRemoved = zoo.removeZone(2);
		assertEquals(true, isRemoved);
			
	}
	
	
	
	
	


}
