package priorityqueue;

public class Main {

	public static void main(String[] args){
		PriorityQueueImpl obj = new PriorityQueueImpl(5);
		obj.addProcess("Process1",9);
		obj.addProcess("Process2",5);
		obj.addProcess("Process4",7);
		obj.addProcess("Process5",2);
		obj.addProcess("Process6",2);
		obj.addProcess("Process7",3);
		obj.displayPriorityQueue();
		obj.deleteProcess();
		obj.displayPriorityQueue();
		obj.deleteProcess();
		obj.displayPriorityQueue();
		obj.addProcess("Process8",10);
		obj.addProcess("Process9",4);
		obj.displayPriorityQueue();
	}
}
