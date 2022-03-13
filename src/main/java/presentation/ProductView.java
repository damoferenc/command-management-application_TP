/**
 * The view class for the product administration user interface
 */

package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ProductView extends JFrame {

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JTextField AddIdTextField;
    private JTextField AddNameTextField;
    private JTextField AddSizeTextField;
    private JTextField AddQuantityTextField;
    private JTextField EditIdTextField;
    private JTextField EditNameTextField;
    private JTextField EditSizeTextField;
    private JTextField EditQuantityTextField;
    private JTextField DeleteIdTextField;
    private JTable table;
    private JPanel tablePanel;
    private JScrollPane jScrollPane;



    public ProductView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        addButton = new JButton("Add product");
        editButton = new JButton("Edit product");
        deleteButton = new JButton("Delete product");
        viewButton = new JButton("View all products");



        JLabel AddIdLabel = new JLabel("ID: ");
        AddIdTextField = new JTextField(3);
        JLabel AddNameLabel = new JLabel("Name: ");
        AddNameTextField = new JTextField(15);
        JLabel AddSizeLabel = new JLabel("Size: ");
        AddSizeTextField = new JTextField(5);
        JLabel AddQuantityLabel = new JLabel("Quantity: ");
        AddQuantityTextField = new JTextField(5);
        JLabel EditIdLabel = new JLabel("ID: ");
        EditIdTextField = new JTextField(3);
        JLabel EditNameLabel = new JLabel("Name: ");
        EditNameTextField = new JTextField(15);
        JLabel EditSizeLabel = new JLabel("Size: ");
        EditSizeTextField = new JTextField(5);
        JLabel EditQuantityLabel = new JLabel("Quantity: ");
        EditQuantityTextField = new JTextField(5);
        JLabel DeleteIdLabel = new JLabel("ID: ");
        DeleteIdTextField = new JTextField(3);

        JPanel addPanel = new JPanel();
        addPanel.add(AddIdLabel);
        addPanel.add(AddIdTextField);
        addPanel.add(AddNameLabel);
        addPanel.add(AddNameTextField);
        addPanel.add(AddSizeLabel);
        addPanel.add(AddSizeTextField);
        addPanel.add(AddQuantityLabel);
        addPanel.add(AddQuantityTextField);
        addPanel.add(addButton);

        JPanel editPanel = new JPanel();
        editPanel.add(EditIdLabel);
        editPanel.add(EditIdTextField);
        editPanel.add(EditNameLabel);
        editPanel.add(EditNameTextField);
        editPanel.add(EditSizeLabel);
        editPanel.add(EditSizeTextField);
        editPanel.add(EditQuantityLabel);
        editPanel.add(EditQuantityTextField);
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

    public int getAddSize() {
        return Integer.parseInt(this.AddSizeTextField.getText()) ;
    }

    public int getAddQuantity() {
        return Integer.parseInt(this.AddQuantityTextField.getText()) ;
    }

    public int getEditId() {
        return Integer.parseInt(this.EditIdTextField.getText()) ;
    }

    public String getEditName() {
        return this.EditNameTextField.getText() ;
    }

    public int getEditSize() {
        if(this.EditSizeTextField.getText().equals("")){
            return -1;
        }
        return Integer.parseInt(this.EditSizeTextField.getText()) ;
    }

    public int getEditQuantity() {
        if(this.EditQuantityTextField.getText().equals("")){
            return -1;
        }
        return Integer.parseInt(this.EditQuantityTextField.getText()) ;
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
