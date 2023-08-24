import com.sun.tools.javac.Main;

/**
 * rectangle
 */
public class rectangle {

	public static void main(String[] args) {
		

	}
}

public class newrectangle {
	double H = 1.0;
	double W = 1.0;

	newrectangle(){

	}
	newrectangle(double newH, double newW){

	
           H = newH;
           H = newW;

	}
	double getArea(){
		return H*W;
	}
	double getperimeter(){
		return 2*(H+W);
	}
	double setnewparameters(double newH, double newW){

		H = newH;
		W = newW;
	}
	
}
