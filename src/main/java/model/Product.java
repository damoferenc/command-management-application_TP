/**
 * The model class for the products
 */

package model;

public class Product {
    private int id;
    private String name;
    private int size;
    private int quantity;

    public Product(int id, String name, int size, int quantity) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }

    public Product(){
        this.id = 0;
        this.name = "";
        this.size = 0;
        this.quantity = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
