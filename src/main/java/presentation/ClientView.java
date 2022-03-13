/**
 * The view class for the client administration user interface
 */

package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JTextField AddIdTextField;
    private JTextField AddNameTextField;
    private JTextField AddAddressTextField;
    private JTextField AddEmailTextField;
    private JTextField AddPhoneNumberTextField;
    private JTextField AddAgeTextField;
    private JTextField EditIdTextField;
    private JTextField EditNameTextField;
    private JTextField EditAddressTextField;
    private JTextField EditEmailTextField;
    private JTextField EditPhoneNumberTextField;
    private JTextField EditAgeTextField;
    private JTextField DeleteIdTextField;
    private JTable table;
    private JPanel tablePanel;
    private JScrollPane jScrollPane;


    public ClientView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        addButton = new JButton("Add client");
        editButton = new JButton("Edit client");
        deleteButton = new JButton("Delete client");
        viewButton = new JButton("View all clients");



        JLabel AddIdLabel = new JLabel("ID: ");
        AddIdTextField = new JTextField(3);
        JLabel AddNameLabel = new JLabel("Name: ");
        AddNameTextField = new JTextField(15);
        JLabel AddAddressLabel = new JLabel("Address: ");
        AddAddressTextField = new JTextField(15);
        JLabel AddEmailLabel = new JLabel("Email: ");
        AddEmailTextField = new JTextField(15);
        JLabel AddPhoneNumberLabel = new JLabel("Phone number: ");
        AddPhoneNumberTextField = new JTextField(9);
        JLabel AddAgeLabel = new JLabel("Age: ");
        AddAgeTextField = new JTextField(3);
        JLabel EditIdLabel = new JLabel("ID: ");
        EditIdTextField = new JTextField(3);
        JLabel EditNameLabel = new JLabel("Name: ");
        EditNameTextField = new JTextField(15);
        JLabel EditAddressLabel = new JLabel("Address: ");
        EditAddressTextField = new JTextField(15);
        JLabel EditEmailLabel = new JLabel("Email: ");
        EditEmailTextField = new JTextField(15);
        JLabel EditPhoneNumberLabel = new JLabel("Phone number: ");
        EditPhoneNumberTextField = new JTextField(9);
        JLabel EditAgeLabel = new JLabel("Age: ");
        EditAgeTextField = new JTextField(3);
        JLabel DeleteIdLabel = new JLabel("ID: ");
        DeleteIdTextField = new JTextField(3);

        JPanel addPanel = new JPanel();
        addPanel.add(AddIdLabel);
        addPanel.add(AddIdTextField);
        addPanel.add(AddNameLabel);
        addPanel.add(AddNameTextField);
        addPanel.add(AddAddressLabel);
        addPanel.add(AddAddressTextField);
        addPanel.add(AddEmailLabel);
        addPanel.add(AddEmailTextField);
        addPanel.add(AddPhoneNumberLabel);
        addPanel.add(AddPhoneNumberTextField);
        addPanel.add(AddAgeLabel);
        addPanel.add(AddAgeTextField);
        addPanel.add(addButton);

        JPanel editPanel = new JPanel();
        editPanel.add(EditIdLabel);
        editPanel.add(EditIdTextField);
        editPanel.add(EditNameLabel);
        editPanel.add(EditNameTextField);
        editPanel.add(EditAddressLabel);
        editPanel.add(EditAddressTextField);
        editPanel.add(EditEmailLabel);
        editPanel.add(EditEmailTextField);
        editPanel.add(EditPhoneNumberLabel);
        editPanel.add(EditPhoneNumberTextField);
        editPanel.add(EditAgeLabel);
        editPanel.add(EditAgeTextField);
        editPanel.add(editButton);

        JPanel deletePanel = new JPanel();
        deletePanel.add(DeleteIdLabel);
        deletePanel.add(DeleteIdTextField);
        deletePanel.add(deleteButton);


        table = new JTable();
        jScrollPane = new JScrollPane(table);

        tablePanel = new JPanel();
        tablePanel.add(viewButton);
        tablePanel.add(jScrollPane);
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));



        JPanel contentPane = new JPanel();
        contentPane.add(addPanel);
        contentPane.add(editPanel);
        contentPane.add(deletePanel);
        contentPane.add(tablePanel);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        this.setContentPane(contentPane);
    }

    public void addAddButtonListener(ActionListener al) {
        this.addButton.addActionListener(al);
    }

    public void addEditButtonListener(ActionListener al) {
        this.editButton.addActionListener(al);
    }

    public void addDeleteButtonListener(ActionListener al) {
        this.deleteButton.addActionListener(al);
    }

    public void addShowButtonListener(ActionListener al) {
        this.viewButton.addActionListener(al);
    }

    public int getAddId() {
        return Integer.parseInt(this.AddIdTextField.getText()) ;
    }

    public String getAddName() {
        return this.AddNameTextField.getText() ;
    }

    public String getAddAddress() {
        return this.AddAddressTextField.getText() ;
    }

    public String getAddEmail() {
        return this.AddEmailTextField.getText() ;
    }

    public String getAddPhoneNumber() {
        return this.AddPhoneNumberTextField.getText() ;
    }

    public int getAddAge() {
        return Integer.parseInt(this.AddAgeTextField.getText()) ;
    }

    public int getEditId() {
        return Integer.parseInt(this.EditIdTextField.getText()) ;
    }

    public String getEditName() {
        return this.EditNameTextField.getText() ;
    }

    public String getEditAddress() {
        return this.EditAddressTextField.getText() ;
    }

    public String getEditEmail() {
        return this.EditEmailTextField.getText() ;
    }

    public String getEditPhoneNumber() {
        return this.EditPhoneNumberTextField.getText() ;
    }

    public int getEditAge() {
        if(this.EditAgeTextField.getText().equals("")){
            return -1;
        }
        return Integer.parseInt(this.EditAgeTextField.getText()) ;
    }

    public int getDeleteId() {

        if(this.DeleteIdTextField.getText().equals("")){
            return -1;
        }
        return Integer.parseInt(this.DeleteIdTextField.getText()) ;
    }

    public void setTable(JTable table){
        tablePanel.remove(1);
        this.table = table;
        this.jScrollPane = new JScrollPane(this.table);
        tablePanel.add(this.jScrollPane);
        revalidate();
    }


}
