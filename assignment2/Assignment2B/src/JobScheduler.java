import java.util.Scanner;

public class JobScheduler {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FCFS objOfFCFS = new FCFS();
		System.out.print("How Many Process Do You Wants To Exicute: ");
		int noOfProcess = scanner.nextInt();

		int[][] timeArray = new int[noOfProcess][2];
		int completionTimeArray[], waitingTimeArray[], turnAroundTimeArray[], maximumWaitingTime;
		float averageWaitingTime;
		
		// To Read Arrival Time And Burst Time
		for (int i = 0; i < noOfProcess; i++) {
			System.out.println("\nFor Process Number " + (i + 1));
			System.out.print("Arrival Time: ");
			timeArray[i][0] = scanner.nextInt();
			System.out.print("Burst Time: ");
			timeArray[i][1] = scanner.nextInt();
		}
		// Sort The Array 
		for (int i = 0; i < noOfProcess; i++) {
			for (int j = i + 1; j < noOfProcess; j++) {
				if(timeArray[i][0]>timeArray[j][0]){
					int temp ;
					temp = timeArray[i][0];
					timeArray[i][0] = timeArray[j][0];
					timeArray[j][0] = temp;
					
					temp = timeArray[i][1];
					timeArray[i][1] = timeArray[j][1];
					timeArray[j][1] = temp;
					
				}
			}
		}
		// To Read Arrival Time And Burst Time
		
		
		completionTimeArray = objOfFCFS.complitionTime(timeArray);
		waitingTimeArray = objOfFCFS.waitingTime(timeArray);
		turnAroundTimeArray = objOfFCFS.turnAroundTime(timeArray);
		averageWaitingTime = objOfFCFS.averageWaitingTime(timeArray);
		maximumWaitingTime = objOfFCFS.maximumWaitingTime(timeArray);
		
		
		System.out
				.println("-----------------------------------------------------------------------------------------");
		System.out
				.println("| Process Number\t| Complition Time\t| WaitingTime\t| Turn Around Time\t|");
		for (int i = 0; i < noOfProcess; i++) {
			System.out.println("| " + (i + 1) + "\t\t\t| "
					+ completionTimeArray[i] + "\t\t\t| " + waitingTimeArray[i]
					+ "\t\t| " + turnAroundTimeArray[i] + "\t\t\t|");
		}
		System.out
				.println("-----------------------------------------------------------------------------------------");
		System.out.println("Average Waiting Time : " + averageWaitingTime);
		System.out.println("Maximum Waiting Time : " + maximumWaitingTime);

		scanner.close();
	}

}
