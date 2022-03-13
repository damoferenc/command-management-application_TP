/**
 * The quantity for products validator class
 */

package bll.validators;

import model.Product;

public class ProductQuantityValidator implements Validator<Product>{

    public void validate(Product t, boolean edit) {
        if(!edit || (edit && t.getQuantity() != -1)){
            if (t.getQuantity() < 0) {
                throw new IllegalArgumentException("Quantity is not a valid quantity!");
            }
        }

    }
}
