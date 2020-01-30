import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTests {

	/* Test Cases For Cage Class */
	
	@Test
	public void addAnimalInCageTestCase(){
		
		Animal animal = new Lion("Lion1", 9, 30);
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(animal);
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void addAnimalInCageMoreThenCapacityTestCase(){
		
		
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		isAdded = cage.addAnimal(new Lion("Lion3", 9, 30));
		assertEquals(false, isAdded);
	}
	
	@Test
	public void removeAnimalFromCageTestCase(){
		
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		boolean isRemoved = cage.removeAnimal(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void removeAnimalWithoutAddingAnyAnimalTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isRemoved = cage.removeAnimal(1);
		assertEquals(false,isRemoved);
		
	}
	
	public void removeAnimalWithWrongIndexTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isRemoved = cage.removeAnimal(5);
		assertEquals(false,isRemoved);
	}
	
	@Test
	public void isSpaceAvailableWhenCageHavingSpaceTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));	
		boolean isSpaceAvailable = cage.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void isSpaceAvailableWhenCageIsFullTestCase(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		boolean isSpaceAvailable = cage.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	

	/* Test Cases For Zone Class */
	
	@Test
	public void addCageInZoneTestCase(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void addCageInZoneMoreThenCapacityTestCase(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		assertEquals(false, isAdded);
		
	}
	
	@Test
	public void removeCageFromZoneTestCase(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		boolean isRemoved = zone.removeCage(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void removeCageWithoutAddingAnyCageTestCase(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isRemoved = zone.removeCage(1);
		assertEquals(false, isRemoved);
		
	}
	
	public void removeCageWithWrongIndexTestCase(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		boolean isRemoved = zone.removeCage(4);
		assertEquals(true, isRemoved);
	}
	
	@Test
	public void isSpaceAvailableWhenZoneHavingSpaceTestCase(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));	
		boolean isSpaceAvailable = zone.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void isSpaceAvailableWhenZoneIsFullTestCase(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		isAdded = zone.addCage(new Cage("Carnivore" , 2));	
		boolean isSpaceAvailable = zone.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	
	

	/* Test Cases For Zoo Class */
	
	@Test
	public void addZoneInZooTestCase(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void addZoneInZooMoreThenCapacityTestCase(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		assertEquals(false, isAdded);
		
	}
	
	@Test
	public void removeZoneFromZooTestCase(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isRemoved = zoo.removeZone(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void removeZoneWithoutAddingAnyZoneTestCase(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isRemoved = zoo.removeZone(1);
		assertEquals(false, isRemoved);
	}
	
	public void removeZoneWithWrongIndexTestCase(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isRemoved = zoo.removeZone(5);
		assertEquals(false, isRemoved);
		
	}
	
	@Test
	public void isSpaceAvailableWhenZooHavingSpaceTestCase(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));	
		boolean isSpaceAvailable = zoo.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void isSpaceAvailableWhenZooIsFullTestCase(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isSpaceAvailable = zoo.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	
}
