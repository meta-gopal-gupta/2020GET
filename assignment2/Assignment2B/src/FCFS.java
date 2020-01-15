public class FCFS {
	
	// Time Taken To Complete
	int[] complitionTime(int timeArray[][]) {
		int[] x = new int[timeArray.length];
		x[0] = timeArray[0][0] + timeArray[0][1];

		for (int i = 1; i < timeArray.length; i++) {

			if (x[i - 1] > timeArray[i][0]) {
				x[i] = x[i - 1] + timeArray[i][1];
			}
			else {
				x[i] = timeArray[i][0] + timeArray[i][1];
			}
		}
		return x;
	}

	// Waiting Time Function
	int[] waitingTime(int timeArray[][]) {
		int[] y = new int[timeArray.length];
		int x = 0;
		x = timeArray[0][0] + timeArray[0][1];
		y[0] = timeArray[0][0];
		for (int i = 1; i < timeArray.length; i++) {
			y[i] = x - timeArray[i][0];
			if (y[i] < 0) {
				y[i] = 0;
			}
			if (x > timeArray[i][0]) {
				x += timeArray[i][1];
			}
			else {
				x = timeArray[i][0] + timeArray[i][1];
			}
		}
		return y;
	}
	
	// difference between the Completion time and the Arrival time
	int[] turnAroundTime(int timeArray[][]) {
		int[] x = new int[timeArray.length];
		int[] y = new int[timeArray.length];
		y = complitionTime(timeArray);
		for (int i = 0; i < timeArray.length; i++) {
			x[i] = y[i] - timeArray[i][0];
		}

		return x;
	}

	float averageWaitingTime(int timeArray[][]) {

		int[] y = new int[timeArray.length];
		int totalTime = 0, average;
		y = waitingTime(timeArray);
		for (int i = 0; i < timeArray.length; i++) {
			totalTime += y[i];
		}
		average = totalTime / timeArray.length;
		return average;
	}

	int maximumWaitingTime(int timeArray[][]) {

		int[] y = new int[timeArray.length];
		int maximumWaitingTime;
		y = waitingTime(timeArray);
		maximumWaitingTime = y[0];

		for (int i = 1; i < timeArray.length; i++) {
			if (maximumWaitingTime < y[i]) {
				maximumWaitingTime = y[i];
			}
		}
		return maximumWaitingTime;
	}
}
