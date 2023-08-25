import java.util.*;
public class Stock {
	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
		System.out.println("input the name of the symbol, name, current price and previous price of the organization ");

		String symbol= input.nextLine();
		String name = input.nextLine();
		double currentprice = input.nextDouble();
		double previousprice = input.nextDouble();
		stock stock1 = new stock(symbol, name, currentprice, previousprice);
		System.out.println(stock1.symbol);
		System.out.println(stock1.name);
		System.out.println(stock1.current_price);
		System.out.println(stock1.previous_price);
		System.out.println(stock1.get_percentagechange());

		input.close();

		 
		
	}
}
