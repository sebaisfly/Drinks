package client;

import models.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drink Ordering App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // ✅ UI Components
        JTextField nameField = new JTextField(); 
        JComboBox<String> branchBox = new JComboBox<>(new String[]{
            "Nakuru Branch", "Mombasa Branch", "Nairobi Branch", "Kisumu Branch"
        });
        JComboBox<String> drinkBox = new JComboBox<>(new String[]{
            "Coke", "Fanta", "Sprite"
        });
        JTextField quantityField = new JTextField();

        JButton submitBtn = new JButton("Place Order");
        JLabel statusLabel = new JLabel("");

        // ✅ Add components to frame
        frame.add(new JLabel("Customer Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Branch:"));
        frame.add(branchBox);
        frame.add(new JLabel("Drink:"));
        frame.add(drinkBox);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);
        frame.add(submitBtn);
        frame.add(statusLabel);

        frame.setVisible(true);

        // ✅ Button Action Listener
        submitBtn.addActionListener(e -> {
            try {
                String customerName = nameField.getText().trim();
                String branchName = (String) branchBox.getSelectedItem();
                String itemName = (String) drinkBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText().trim()); 

                if (customerName.isEmpty() || quantity <= 0) {
                    statusLabel.setText("Enter valid name and quantity!");
                    return;
                }

                Order order = new Order(customerName, itemName, quantity, branchName); 

                // Send order to server
                Socket socket = new Socket("localhost", 5000);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(order);
                out.flush();
                socket.close();

                statusLabel.setText("Order placed successfully!");
                nameField.setText("");
                quantityField.setText("");
            } catch (Exception ex) {
                statusLabel.setText("Error placing order: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}
