/**
 * The age validator class
 */

package bll.validators;

import java.util.regex.Pattern;

import model.Client;

public class AgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 120;

    /**
     * Age must be greater than 7 and smaller than 120
     * @param t the object
     * @param edit indicates if we want to edit the object or not
     */
    public void validate(Client t, boolean edit) {
        if(!edit || (edit && (t.getAge() != -1)))
        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }

    }


}
