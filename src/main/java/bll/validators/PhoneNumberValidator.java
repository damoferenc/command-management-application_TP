/**
 * The phone number validator class
 */

package bll.validators;

import model.Client;

public class PhoneNumberValidator implements Validator<Client>{

    public void validate(Client t, boolean edit) {
        if(!edit || (edit && !t.getPhoneNumber().equals(""))){
            if (t.getPhoneNumber().length() != 9) {
                throw new IllegalArgumentException("The phone number is not a valid phone number!");
            }
        }


    }

}
