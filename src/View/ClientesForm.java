package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientesForm extends JPanel {

    private JTextField firstnameField;
    private JTextField lastNameField;
    private JTextField fonoField;
    private JButton addButton;
    private JButton viewButton;


    public ClientesForm() {

        JLabel firstnameLabel = new JLabel("Nombre: ");
        JLabel lastnameLabel = new JLabel("Apellido: ");
        JLabel fonoLabel = new JLabel("Teléfono: ");

        firstnameField = new JTextField(25);
        lastNameField = new JTextField(25);
        fonoField = new JTextField(25);

        addButton = new JButton("Agregar Cliente");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("Ver Clientes");
        viewButton.setPreferredSize(new Dimension(278, 40));


        Insets fieldsInset = new Insets(0, 0, 10, 0);

        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(firstnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(lastNameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(fonoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(fonoField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);

    }

    public String getNombre() {
        return firstnameField.getText();
    }
    public String getApellido() {
        return lastNameField.getText();
    }
    public String getTelefono() {return fonoField.getText();}

    public void submitClientes(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void verClientes(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }


    // reset
    public void reset(boolean bln) {
        if(bln) {
            firstnameField.setText("");
            lastNameField.setText("");
            fonoField.setText("");
        }
    }
}
