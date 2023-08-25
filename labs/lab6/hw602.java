import java.util.*;

/**
 * lab602
 */
public class hw602 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double product1 = input.nextDouble();
    double product2 = input.nextDouble();
    double product3 = input.nextDouble();
    double product4 = input.nextDouble();
    double product5 = input.nextDouble();
    double product6 = input.nextDouble();
    System.out.println(priceCalculation(product1));
    System.out.println(priceCalculation(product2, product3));
    System.out.println(priceCalculation(product4, product5, product6));
    input.close();

    

  }
  public static double  priceCalculation(double x1){
    x1 = x1+(0.5*x1);
    return x1;
    
  }
  public static double  priceCalculation(double x2, double x3){
    return x2+x3;
    
  }
  public static double  priceCalculation(double x4, double x5 , double x6){

    double totalprice = x4+x5+x6;

    if(totalprice<200){
      return totalprice + 50;

    }
    if(totalprice>=200 && totalprice<=400){
     return  totalprice;
    }
    if(totalprice>400){
      return totalprice - 50;
    }
    return 0;
    
   

  }   
}
