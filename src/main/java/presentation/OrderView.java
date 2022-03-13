/**
 * The view class for the order making user interface
 */

package presentation;

import dao.AbstractDAO;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderView extends JFrame {

    private JComboBox productBox;
    private JComboBox clientBox;
    private JLabel productLabel;
    private JLabel clientLabel;
    private JLabel quantityLabel;
    private JButton makeOrderButton;
    private JTextField quantityField;
    private JPanel orderPanel;

    public OrderView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        productLabel = new JLabel("Product: ");
        clientLabel = new JLabel("Client: ");
        makeOrderButton = new JButton("MAKE ORDER");
        quantityField = new JTextField(5);
        productBox = new JComboBox();
        clientBox = new JComboBox();
        quantityLabel = new JLabel("Quantity: ");


        orderPanel = new JPanel();
        orderPanel.add(productLabel);
        orderPanel.add(productBox);
        orderPanel.add(clientLabel);
        orderPanel.add(clientBox);
        orderPanel.add(quantityLabel);
        orderPanel.add(quantityField);
        orderPanel.add(makeOrderButton);


        JPanel contentPane = new JPanel();
        contentPane.add(orderPanel);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));



        this.setContentPane(contentPane);

    }

    public void refreshData(ArrayList<Client> clients, ArrayList<Product> products){
        String[] clientsString = new String[clients.size()];
        int i = 0;
        for(Client client : clients){
            clientsString[i] = client.getName();
            clientsString[i] = clientsString[i] + "(" + client.getId() + ")";
            i++;
        }

        String[] productString = new String[products.size()];
        i = 0;
        for(Product product : products){
            productString[i] = product.getName();
            productString[i] = productString[i] + "(" + product.getId() + ")";
            i++;
        }

        this.productBox = new JComboBox(productString);
        this.clientBox = new JComboBox(clientsString);

        for(int j = 0; j < 7; j ++){
            orderPanel.remove(0);
        }

        orderPanel.add(productLabel);
        orderPanel.add(productBox);
        orderPanel.add(clientLabel);
        orderPanel.add(clientBox);
        orderPanel.add(quantityLabel);
        orderPanel.add(quantityField);
        orderPanel.add(makeOrderButton);
        revalidate();

    }

    public void addMakeOrderButtonListener(ActionListener al) {
        this.makeOrderButton.addActionListener(al);
    }

    public int getQuantity() {
        return Integer.parseInt(this.quantityField.getText()) ;
    }

    public int getProductIndex(){
        return this.productBox.getSelectedIndex();
    }

    public int getClientIndex(){
        return this.clientBox.getSelectedIndex();
    }

}
