package server;
 import java.util.List;
import java.util.ArrayList;
import models.Order;
public class OrderManager {
   private List<Order> orders = new ArrayList<>();

   public void addOrder(Order order){
    orders.add(order);

   }
public List<Order> getAllOrders(){
    return orders;
}
public double getTotalSales(){
    //assume 100/= per drink
    return orders.size() *100.0;
}
public void printReport(){
System.out.println("====SALES REPORT====");
for (Order order : orders){
    System.out.println(order);
}
System.out.println("Total Sales: KES " + getTotalSales());

  }

}
