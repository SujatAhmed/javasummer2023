import com.sun.tools.javac.Main;

/**
 * rectangle
 */
public class rectangle {

	public static void main(String[] args) {
	    newrectangle rect1 = new newrectangle();
		System.out.println(rect1.H);
		

	}
}

class newrectangle {
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
	void setnewparameters(double newH, double newW){

		H = newH;
		W = newW;
	}
	
}
