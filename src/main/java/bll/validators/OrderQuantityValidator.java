/**
 * The quantity for orders validator class
 */

package bll.validators;


import model.Order;
import model.Product;

public class OrderQuantityValidator implements Validator<Order>{

    public void validate(Order t, boolean edit) {
        if(!edit || (edit && t.getQuantity() != -1)){
            if (t.getQuantity() < 1) {
                throw new IllegalArgumentException("The quantity is not a valid quantity!");
            }
        }

    }

}
