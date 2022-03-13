/**
 * The business logic class for the products
 */
package bll;


import bll.validators.ProductQuantityValidator;
import bll.validators.SizeValidator;
import bll.validators.Validator;
import dao.AbstractDAO;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    private static List<Validator<Product>> validators;
    private ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new SizeValidator());
        validators.add(new ProductQuantityValidator());
        productDAO = new ProductDAO();
    }

    /**
     *
     * @param id the id of the client we want to find
     * @return the id
     */
    public Product findClientById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     *
     * @param product the object we want to insert
     * @return the id of the object
     */
    public int insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product, false);
        }
        return productDAO.insert(product).getId();
    }

    /**
     *
     * @param product
     * @return
     */
    public int updateProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product, true);
        }
        return productDAO.update(product).getId();
    }

    /**
     *
     * @param id the id of the object we want to delete
     * @return the id of the object
     */
    public int deleteProduct(int id) {

        productDAO.deleteById(id);
        return id;
    }

    /**
     *
     * @return a list with the objects in the database
     */
    public List<Product> findAll(){
        return productDAO.findAll();
    }


}
