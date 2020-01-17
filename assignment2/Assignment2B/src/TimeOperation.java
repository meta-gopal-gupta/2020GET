public class TimeOperation {
	
	int[][] arraySorting(int[][] timeArray){
		int noOfProcess = timeArray.length;
		for (int outerIndex = 0; outerIndex < noOfProcess; outerIndex++) {
			for (int innerIndex = outerIndex + 1; innerIndex < noOfProcess; innerIndex++) {
				if(timeArray[outerIndex][0]>timeArray[innerIndex][0]){
					int temp ;
					temp = timeArray[outerIndex][0];
					timeArray[outerIndex][0] = timeArray[innerIndex][0];
					timeArray[innerIndex][0] = temp;
					
					temp = timeArray[outerIndex][1];
					timeArray[outerIndex][1] = timeArray[innerIndex][1];
					timeArray[innerIndex][1] = temp;
					
				}
			}
		}
		return timeArray;
	}
	
	
	// Time Taken To Complete
	int[] complitionTime(int timeArray[][]) {
		int[] x = new int[timeArray.length];
		x[0] = timeArray[0][0] + timeArray[0][1];

		for (int index = 1; index < timeArray.length; index++) {

			if (x[index - 1] > timeArray[index][0]) {
				x[index] = x[index - 1] + timeArray[index][1];
			}
			else {
				x[index] = timeArray[index][0] + timeArray[index][1];
			}
		}
		return x;
	}

	// Waiting Time Function
	int[] waitingTime(int timeArray[][]) {
		int[] waitingTimeArray = new int[timeArray.length];
		int x = 0;
		x = timeArray[0][0] + timeArray[0][1];
		waitingTimeArray[0] = timeArray[0][0];
		for (int index = 1; index < timeArray.length; index++) {
			waitingTimeArray[index] = x - timeArray[index][0];
			if (waitingTimeArray[index] < 0) {
				waitingTimeArray[index] = 0;
			}
			if (x > timeArray[index][0]) {
				x += timeArray[index][1];
			}
			else {
				x = timeArray[index][0] + timeArray[index][1];
			}
		}
		return waitingTimeArray;
	}
	
	// difference between the Completion time and the Arrival time
	int[] turnAroundTime(int timeArray[][]) {
		int[] turnAroundTimeArray = new int[timeArray.length];
		int[] complitionTimeArray = new int[timeArray.length];
		complitionTimeArray = complitionTime(timeArray);
		for (int index = 0; index < timeArray.length; index++) {
			turnAroundTimeArray[index] = complitionTimeArray[index] - timeArray[index][0];
		}

		return turnAroundTimeArray;
	}

	float averageWaitingTime(int timeArray[][]) {

		int[] waitingTimeArray = new int[timeArray.length];
		int totalTime = 0, average;
		waitingTimeArray = waitingTime(timeArray);
		for (int index = 0; index < timeArray.length; index++) {
			totalTime += waitingTimeArray[index];
		}
		average = totalTime / timeArray.length;
		return average;
	}

	int maximumWaitingTime(int timeArray[][]) {

		int[] waitingTimeArray = new int[timeArray.length];
		int maximumWaitingTime;
		waitingTimeArray = waitingTime(timeArray);
		maximumWaitingTime = waitingTimeArray[0];

		for (int index = 1; index < timeArray.length; index++) {
			if (maximumWaitingTime < waitingTimeArray[index]) {
				maximumWaitingTime = waitingTimeArray[index];
			}
		}
		return maximumWaitingTime;
	}
}
