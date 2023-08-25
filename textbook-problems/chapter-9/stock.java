
public class stock{
	String symbol;
	String name;
	double current_price;
	double previous_price;
	stock(String s, String n, double c, double p){
		symbol = s;
		name = n;
		current_price = c;
		previous_price = p;


	}
   double get_percentagechange() {

		return ((current_price - previous_price)/current_price)*100;
	}

}
