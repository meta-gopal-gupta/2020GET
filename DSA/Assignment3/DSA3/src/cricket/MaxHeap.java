package cricket;

public class MaxHeap {
	public static int size = -1;
	public static int maxSize = 10;
	public static HeapStructure[] heap = new HeapStructure[maxSize];
	
	private static int parent(int current) {
		return current/2;
	}
	
	private static void swap(int current, int parent) {
		HeapStructure temp;
		temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}
	
	public static void insert(int data) {
		if (size == -1){
			HeapStructure newHeap = new HeapStructure(data, -1);
			heap[++size] = newHeap;
		}
		else{
			HeapStructure newHeap = new HeapStructure(data, ++size);
			System.out.println(size);
			heap[size] = newHeap;
			int current = size;
			while (heap[current].ball > heap[parent(current)].ball){
				swap(current, parent(current));
				current = parent(current);
			}
		}
	}

	public static void matchOn() {
		while (size != 0){
			heap[1].ball -= 1;
			System.out.println("bowler " +heap[1].bowler +" remain ball " +heap[1].ball);
			if (heap[1].ball == 0)
				extract();
			heapify(1);
		}
	}
	
	private static void extract() {
		heap[1] = heap[size--];
	}

	private static void heapify(int pos) {
		if (isLeaf(pos))
			return;
		
		if (heap[pos].ball < heap[leftChild(pos)].ball || heap[pos].ball < heap[rightChild(pos)].ball)
			if (heap[leftChild(pos)].ball > heap[rightChild(pos)].ball){
				swap(pos, leftChild(pos));
				heapify(leftChild(pos));
			}
			else{
				swap(pos, rightChild(pos));
				heapify(rightChild(pos));
			}
	}

	private static int rightChild(int pos) {
		return (pos*2)+1;
	}

	private static int leftChild(int pos) {
		return pos*2;
	}

	private static boolean isLeaf(int pos) {
		if (pos >= (size+1)/2 && pos <= size)
			return true;
		return false;
	}	
}
