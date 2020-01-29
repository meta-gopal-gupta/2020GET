
public class ZooFactory {
	public static Animal addAnimal(String type,int animalAge, String animalName, int animalWeight){

		Animal animal = null;
		if("Lion".equalsIgnoreCase(type)){
			animal = new Eagle(animalName, animalAge, animalWeight);
		}
		
		if("Tiger".equalsIgnoreCase(type)){
			animal = new Tiger(animalName, animalAge, animalWeight);
		}
		
		if("Peacock".equalsIgnoreCase(type)){
			animal = new Peacock(animalName, animalAge, animalWeight);
		}
			
		if("Eagle".equalsIgnoreCase(type)){
			animal = new Eagle(animalName, animalAge, animalWeight);
		}
			
		if("Snake".equalsIgnoreCase(type)){
			animal = new Snake(animalName, animalAge, animalWeight);
		}
			
		if("Crocodile".equalsIgnoreCase(type)){
			animal = new Crocodile(animalName, animalAge, animalWeight);
		}
			

		return animal;
	}
}
