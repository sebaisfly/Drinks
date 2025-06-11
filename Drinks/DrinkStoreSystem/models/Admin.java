package models;
import java.util.HashMap;
import java.util.Map;

public class Admin{
    private Map<String, Integer> stockLevels = new HashMap<>();
    private final int Stock_Threshold = 5;

    public Admin(){
        stockLevels.put("Coke", 10);
        stockLevels.put("Sprite", 6);
        stockLevels.put("Fanta", 8);
    } // starting stock for each item
//check if enough stock is available
public boolean checkStock(String item, int quantity){
    return stockLevels.getOrDefault(item, 0)>=quantity;
}
//reduce stock after order
public void reduceStock(String item, int quantity){
    int availableStock = stockLevels.getOrDefault(item, 0);
    int updatedStock = availableStock - quantity;
    stockLevels.put(item,updatedStock);

    if(updatedStock <= Stock_Threshold){
        System.out.println("[ALERT] Low stock for " + item + " : " + updatedStock + " units remaining.");
        // Trigger restock process
    }
 }
 public void printStockReport(){
System.out.println("=====STOCK REPORT=====");
for(Map.Entry<String, Integer > entry : stockLevels.entrySet()){
    System.out.println(entry.getKey() + ": " + entry.getValue() + " units available.");
     }
   }
}