/**
 * The model class for the orders
 */

package model;

public class Order {
    private int id;
    private int clientId;
    private int productId;
    private int quantity;

    public Order(int id, int clientId, int productId, int quantity) {
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order(){
        this.id = 0;
        this.clientId = 0;
        this.productId = 0;
        this.quantity = 0;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setClientId(int clientId){
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
