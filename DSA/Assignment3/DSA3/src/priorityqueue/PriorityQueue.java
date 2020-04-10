package priorityqueue;

public interface PriorityQueue {

	boolean addProcess(String process, int priority);
	void deleteProcess();
	void displayPriorityQueue();
}
