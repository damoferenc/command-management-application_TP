/**
 * The main class of the application
 * Instantiates the view classes and the controller class
 */

import presentation.ClientView;
import presentation.Controller;
import presentation.OrderView;
import presentation.ProductView;

public class MainClass {

    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();

        Controller controller = new Controller(clientView, productView, orderView);

        clientView.setVisible(true);
        productView.setVisible(true);
        orderView.setVisible(true);

    }



}
