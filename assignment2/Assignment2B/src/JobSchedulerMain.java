import java.util.Scanner;

public class JobSchedulerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TimeOperation computeTime = new TimeOperation();
		System.out.print("How Many Process Do You Wants To Exicute: ");
		int noOfProcess = scanner.nextInt();

		int[][] timeArray = new int[noOfProcess][2];
		int completionTimeArray[], waitingTimeArray[], turnAroundTimeArray[], maximumWaitingTime;
		float averageWaitingTime;
		
		// To Read Arrival Time And Burst Time
		for (int index = 0; index < noOfProcess; index++) {
			System.out.println("\nFor Process Number " + (index + 1));
			System.out.print("Arrival Time: ");
			timeArray[index][0] = scanner.nextInt();
			System.out.print("Burst Time: ");
			timeArray[index][1] = scanner.nextInt();
		}
		// Sort The Array 

		timeArray = computeTime.arraySorting(timeArray);
		// To Read Arrival Time And Burst Time
		
		
		completionTimeArray = computeTime.complitionTime(timeArray);
		waitingTimeArray = computeTime.waitingTime(timeArray);
		turnAroundTimeArray = computeTime.turnAroundTime(timeArray);
		averageWaitingTime = computeTime.averageWaitingTime(timeArray);
		maximumWaitingTime = computeTime.maximumWaitingTime(timeArray);
		
		
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
