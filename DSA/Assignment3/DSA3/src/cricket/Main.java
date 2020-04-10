package cricket;

public class Main {

	public static void main(String[] args){
		MaxHeap.insert(Integer.MAX_VALUE);
		MaxHeap.insert(5);
		MaxHeap.insert(6);
		MaxHeap.insert(7);
		MaxHeap.matchOn();
	}
}
