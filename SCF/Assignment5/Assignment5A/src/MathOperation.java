public class MathOperation {
	
	/**
	 * 
	 * @param X First Integer Value
	 * @param Y Second Integer Value
	 * @return HCF of XY
	 */
	int HCFofXY(int X,int Y){
		if(!(X<0||Y<0)){
			if(Y!=0){
				return HCFofXY(Y,X%Y);
			}
			else{
				return X;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param X First Integer Value
	 * @param Y Second Integer Value
	 * @return HCF of XY
	 * here we are using above HCFofXY function
	 */
	int LCMofXY(int X,int Y){
		
		if(!(X<0||Y<0)){
			int HCF = HCFofXY(X,Y);
			int LCM = X*Y/HCF;
			return LCM;
		}
		return -1;
	}
	
	
}
