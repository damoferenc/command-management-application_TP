/**
 * The validator interface
 */

package bll.validators;

public interface Validator<T> {
    /**
     *
     * @param t the object
     * @param edit indicates if we want to edit the object or not
     */
    public void validate(T t, boolean edit);
}
