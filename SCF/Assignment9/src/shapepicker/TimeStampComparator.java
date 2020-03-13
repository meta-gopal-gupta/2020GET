package shapepicker;

import java.util.Comparator;

/**
 * This class implements comparator to sort objects based on time-stamp.
 * @author Gopal
 *
 */
public class TimeStampComparator implements Comparator<Shape> {
	public int compare(Shape s1,Shape s2){  
		if(s1.getTimeStamp()==s2.getTimeStamp())
			return 0;  
		else if(s1.getTimeStamp().after(s2.getTimeStamp()))  
			return 1;  
		else
			return -1;  
	}
}
