package View;

import Model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientesDetails extends JPanel {



    private JTable clientesTable;
    private String[] clientesTableColumn = {"NOMBRE", "APELLIDO", "TELÉFONO", "ID"};
    private JButton backButton;
    private JButton eliminarButton;

    public ClientesDetails() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JToolBar toolBar = new JToolBar();
        clientesTable = new JTable();

        JScrollPane userTableScroll = new JScrollPane(clientesTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("SALIR");
        eliminarButton = new JButton("Eliminar Cliente Seleccionado");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.add(eliminarButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    // carga table desde database
    public void getClientes(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) clientesTable.getModel();
        defaultTableModel.setColumnIdentifiers(clientesTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    public void getClientesJson(ArrayList<Cliente> lista) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) clientesTable.getModel();
        defaultTableModel.setColumnIdentifiers(clientesTableColumn);
        int i = 0;
        while(i < lista.size()) {
            String row = lista.get(i).displayCliente().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    public void reset() {
        DefaultTableModel dm = (DefaultTableModel) clientesTable.getModel();
        dm.setRowCount(0);
        }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void eliminarButton(ActionListener actionListener) {
        eliminarButton.addActionListener(actionListener);
    }

    public int getClienteTable() {
        return clientesTable.getSelectedRow();
    }
}
