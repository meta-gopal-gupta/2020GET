package counseling;

public class Queue{
    int rear, front;
    int size;
    String queue[];


    Queue(int arraySize) {
	    queue = new String[arraySize];
	}

	public boolean isFull() {
		if (size == queue.length)
			return true;
		return false;
	}
	
	public void enqueue(String data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			size++;
			front = front%(queue.length);
			queue[front++] = data;
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
				System.out.print(queue[index]+", ");
			for (int index=0; index!=front; index++)
				System.out.print(queue[index]+", ");
		}
		else
			for (int indexi=rear; indexi<front; indexi++)
				System.out.print(queue[indexi]+", ");
		System.out.println();
	}


    public String[] getQueue() {
        return queue;
    }
}
