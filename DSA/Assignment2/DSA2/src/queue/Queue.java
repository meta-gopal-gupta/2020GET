package queue;

public class Queue {
private int queue[], front, rear, size;
	
	Queue(int arraySize) {
	    queue = new int[arraySize];
	}

	private boolean isFull() {
		if (size == queue.length)
			return true;
		return false;
	}
	
	public void enqueue(int data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			size++;
			front = front%(queue.length);
			queue[front++] = data;
			System.out.println("enqueue "+data);
		}
	}

	public String dequeue() {
		if (isEmpty()){
			return "queue is empty";
		}
		else{
			size--;
			return "Dequeue "+queue[rear++];
		}
	}
	
	private boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public void display() {
		if (front <= rear){
			for (int index=rear; index<queue.length; index++)
				System.out.print(queue[index]+"->");
			for (int index=0; index!=front; index++)
				System.out.print(queue[index]+"->");
		}
		else
			for (int indexi=rear; indexi<front; indexi++)
				System.out.print(queue[indexi]+"->");
	}

}
