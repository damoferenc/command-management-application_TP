/**
 * The model class for the clients
 */


package model;

public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private int age;


    public Client(int id, String name, String address, String email, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Client(){
        this.id = 0;
        this.name = "";
        this.address = "";
        this.email = "";
        this.phoneNumber = "";
        this.age = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
