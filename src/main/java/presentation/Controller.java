package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import model.Client;
import model.Order;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ClientView clientView;
    private ClientBLL clientBLL;
    private ProductView productView;
    private ProductBLL productBLL;
    private OrderView orderView;
    private OrderBLL orderBLL;


    public Controller(ClientView clientview, ProductView productView, OrderView orderView){
        this.clientView = clientview;
        this.clientBLL = new ClientBLL();
        this.productView = productView;
        this.productBLL = new ProductBLL();
        this.orderView = orderView;
        this.orderBLL = new OrderBLL();

        this.clientView.addAddButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Client client = new Client(
                        clientView.getAddId(),
                        clientView.getAddName(),
                        clientView.getAddAddress(),
                        clientView.getAddEmail(),
                        clientView.getAddPhoneNumber(),
                        clientView.getAddAge()
                );
                int id = clientBLL.insertClient(client);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.productView.addAddButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Product product = new Product(
                        productView.getAddId(),
                        productView.getAddName(),
                        productView.getAddSize(),
                        productView.getAddQuantity()
                );
                int id = productBLL.insertProduct(product);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.clientView.addEditButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Client client = new Client(
                        clientView.getEditId(),
                        clientView.getEditName(),
                        clientView.getEditAddress(),
                        clientView.getEditEmail(),
                        clientView.getEditPhoneNumber(),
                        clientView.getEditAge()
                );
                int id = clientBLL.updateClient(client);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.productView.addEditButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Product product = new Product(
                        productView.getEditId(),
                        productView.getEditName(),
                        productView.getEditSize(),
                        productView.getEditQuantity()
                );
                int id = productBLL.updateProduct(product);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.clientView.addDeleteButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int id = clientView.getDeleteId();
                id = clientBLL.deleteClient(id);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.productView.addDeleteButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int id = productView.getDeleteId();
                id = productBLL.deleteProduct(id);
                orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());
            }

        });

        this.clientView.addShowButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ArrayList<Client> clientList = (ArrayList<Client>)clientBLL.findAll();
                ArrayList<Object> objectList = cast(clientList);
                clientView.setTable(generateTable(objectList));
            }

        });

        this.productView.addShowButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ArrayList<Product> productList = (ArrayList<Product>)productBLL.findAll();
                ArrayList<Object> objectList = cast(productList);
                productView.setTable(generateTable(objectList));
            }


        });

        this.orderView.addMakeOrderButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Client client = ((ArrayList<Client>)clientBLL.findAll()).get(orderView.getClientIndex());
                Product product = ((ArrayList<Product>)productBLL.findAll()).get(orderView.getProductIndex());
                Order order = new Order(orderBLL.generateId(), client.getId(), product.getId(), orderView.getQuantity());
                if(product.getQuantity() >= order.getQuantity()){
                    orderBLL.insertOrder(order);
                    product.setQuantity(product.getQuantity() - order.getQuantity());
                    int id = productBLL.updateProduct(product);
                    try{
                        Document document = new Document();
                        try{
                            PdfWriter.getInstance(document, new FileOutputStream("order" + order.getId() + ".pdf"));

                        }catch(FileNotFoundException exception){

                        }

                        document.open();
                        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                        String bill = new String();
                        bill = bill + "Order ID: " + order.getId() + "\n";
                        bill = bill + "Client ID: " + client.getId() + "\n";
                        bill = bill + "Client name: " + client.getName() + "\n";
                        bill = bill + "Client tel: " + client.getPhoneNumber() + "\n";
                        bill = bill + "Client email: " + client.getEmail() + "\n";
                        bill = bill + "Client address: " + client.getAddress() + "\n";
                        bill = bill + "Client age: " + client.getAge() + "\n";
                        bill = bill + "Product ID: " + product.getId() + "\n";
                        bill = bill + "Product name: " + product.getName() + "\n";
                        bill = bill + "Product size: " + product.getSize() + "\n";
                        bill = bill + "Product quantity: " + order.getQuantity() + "\n";
                        Paragraph paragraph = new Paragraph(bill, font);

                        document.add(paragraph);
                        document.close();
                    }catch(DocumentException exception){

                    }

                }
                else{
                    JOptionPane.showMessageDialog(null,"Not enough product");

                }
            }
        });

        orderView.refreshData((ArrayList<Client>) clientBLL.findAll(), (ArrayList<Product>) productBLL.findAll());

    }

    public static <T> ArrayList<T> cast(ArrayList list) {
        return list;
    }

    /**
     *
     * @param object an object
     * @return the number of fields of the object
     */
    int getNumberOfColumns(Object object){
        int i = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            i++;

        }
        return i;
    }

    /**
     * Generates a JTable object from an arraylist of objects
     * @param objectList the arraylist
     * @return the generated JTable object
     */
    public JTable generateTable(ArrayList<Object> objectList){
        int i = 0;
        String[][] data = new String[objectList.size()][getNumberOfColumns(objectList.get(0))];
        String[] column = new String[getNumberOfColumns(objectList.get(0))];
        for(Object object : objectList){
            int j = 0;
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(object);
                    if(i == 0){
                        column[j] = field.getName();
                    }
                    data[i][j++] = value.toString();

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            i++;

        }
        return new JTable(data,column);

    }


}
