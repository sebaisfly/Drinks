package models;
import java.io.Serializable;
import java.time.LocalDateTime;
public class Order implements Serializable {
    private String customerName;
    private String itemName;
    private int quantity;
    private String branchName;
    private LocalDateTime orderTime;

public Order (String customerName, String itemName, int quantity, String branchName) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.branchName = branchName;
        this.orderTime = LocalDateTime.now();
    }

    public String getCustomer() {
        return customerName;
    }

    public String getItem() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBranchName() {
        return branchName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    @Override
    public String toString(){
        return "[" + branchName + "]" +customerName + " ordered " + quantity + " x " + itemName + " at " + orderTime;
    }

















}
