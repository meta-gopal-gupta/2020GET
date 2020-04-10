package uniquechar;

public class Main {

        public static void main(String[] args){
        	UniqueChar char1 = new UniqueChar();
        	if(char1.addCharFromString("This is gopal6")){
        		System.out.println("Unique Characters : "+ char1.sizeOfSet());
        	}
        	if(char1.addCharFromString(" asdfasdf")){
        		System.out.println("Unique Characters : "+ char1.sizeOfSet());
        	}
        	if(char1.addCharFromString(" thisissithis ")){
        		System.out.println("Unique Characters : "+ char1.sizeOfSet());
        	}
        }
}
