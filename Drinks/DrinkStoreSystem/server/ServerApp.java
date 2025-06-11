package server;
import models.Order;
import java.io.*;
import java.net.*;

public class ServerApp{
    public static void main(String[] args) {
        try(ServerSocket serversocket = new ServerSocket(5000)){
            System.out.println("Admin server running on port 5000...");
            while (true) {
                Socket socket = serversocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                Order order = (Order) input.readObject();
                System.out.println("Received order: " + order);
                // Here you would handle the order, e.g., add to branch, update stock, etc.
                input.close();
                socket.close();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
