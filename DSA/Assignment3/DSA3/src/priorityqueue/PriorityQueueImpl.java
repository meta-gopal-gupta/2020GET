package priorityqueue;

/*@author Gopal Gupta
 * Class to perform priority queue operation 
 * */
public class PriorityQueueImpl implements PriorityQueue{
	
	private Queue[] priQueue;
	private int front=-1,rear=-1;
	private int queueSize;
	
	public PriorityQueueImpl(int queueSize){
		this.queueSize = queueSize;
		priQueue = new Queue[queueSize];
	}
	
	
	
	/*function to add process in queue
	 * @param process,priority 
	 * */
	@Override
	public boolean addProcess(String process, int priority){
		Queue newProcess = new Queue(process,priority);
		
		if(isQueueFull()){
			System.out.println("Your queue is full\n" );
			return false;
		}
		if(front==-1){
			front++;
			rear++;
			priQueue[rear]=newProcess;
		}
		else if(rear==4 && front!=0){
			rear=0;
			priQueue[rear]=newProcess;
		}
		else{
			rear++;
			priQueue[rear]=newProcess;
		}
		priorityQueue();
		return true;
	}
	
	
	public boolean isQueueFull(){
		if(queueSize == rear + front +1 ){
			return true;
		}
		return false;
	}
	
	
	/*
	 * function to arrange process priority wise
	 * */
	public void priorityQueue(){
		for(int i=front;i<=rear;i++){
			for(int j=front+1;j<=rear;j++)
				if(priQueue[j-1].priority < priQueue[j].priority){
					Queue temp;
					temp=priQueue[j-1];
					priQueue[j-1] = priQueue[j];
					priQueue[j] = temp;
				}
		}
	}
	
	/*function to delete process
	 * */
	@Override
	public void deleteProcess(){
		for(int i=front;i<=rear-1;i++){
			priQueue[i]=priQueue[i+1];
		}
		rear--;
	}
	
	/*function to display priority queue
	 * */
	@Override
	public void displayPriorityQueue(){
		for(int i=front;i<=rear;i++){
			System.out.println(priQueue[i].process);
			}
		System.out.println("\n\n");
	}
}
