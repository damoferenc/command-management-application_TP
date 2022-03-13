/**
 * The business logic class for the orders
 */

package bll;

import bll.validators.OrderQuantityValidator;
import bll.validators.Validator;
import dao.OrderDAO;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderBLL {

    private List<Validator<Order>> validators;
    private OrderDAO orderDAO;

    public OrderBLL() {
        validators = new ArrayList<Validator<Order>>();
        validators.add(new OrderQuantityValidator());
        orderDAO = new OrderDAO();
    }

    /**
     *
     * @param order the object we want to insert
     * @return the id of the object
     */
    public int insertOrder(Order order) {
        for (Validator<Order> v : validators) {
            v.validate(order, false);
        }
        return orderDAO.insert(order).getId();
    }

    /**
     *
     * @return the generated id
     */
    public int generateId(){
        ArrayList<Order> orderList = (ArrayList<Order>)orderDAO.findAll();
        return orderList.get(orderList.size() - 1).getId() + 1;
    }

}
