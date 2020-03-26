package counseling;

import java.io.IOException;
/***
 * 
 * @author Gopal
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CollegeCounseling counseling = new CollegeCounseling();
        
        counseling.allotBranch();
        counseling.displayAllottedResult();
        counseling.saveData();
    }
}
