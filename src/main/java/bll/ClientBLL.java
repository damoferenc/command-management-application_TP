/**
 * The business logic class for the clients
 */

package bll;

import bll.validators.AgeValidator;
import bll.validators.EmailValidator;
import bll.validators.PhoneNumberValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        validators.add(new PhoneNumberValidator());
        clientDAO = new ClientDAO();
    }

    /**
     *
     * @param id the client id
     * @return the found object
     */
    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     *
     * @param client the object to be inserted
     * @return the id of the object
     */
    public int insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client,false);
        }
        return clientDAO.insert(client).getId();
    }

    /**
     *
     * @param client the object that we want to update
     * @return the id of the object
     */
    public int updateClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client, true);
        }
        return clientDAO.update(client).getId();
    }

    /**
     *
     * @param id the id of the object we want to delete
     * @return the id
     */
    public int deleteClient(int id) {

        clientDAO.deleteById(id);
        return id;
    }


    /**
     *
     * @return the list of the clients in the database
     */
    public List<Client> findAll(){
        return clientDAO.findAll();
    }

}
