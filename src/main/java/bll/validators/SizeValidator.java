/**
 * The size validator class
 */

package bll.validators;

import model.Product;

import java.util.regex.Pattern;

public class SizeValidator implements Validator<Product>{

    public void validate(Product t, boolean edit) {
        if(!edit || (edit && t.getSize() != -1))
        if (t.getSize() < 1) {
            throw new IllegalArgumentException("Size is not a valid size!");
        }
    }


}

