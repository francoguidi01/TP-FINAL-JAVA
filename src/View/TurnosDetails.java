package View;

import Model.MapaGenerico;
import Model.Turno;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TurnosDetails extends JPanel {

    private JTable turnosTable;
    private String[] turnosTableColumn = {"FECHA", "HORA", "PRECIO","MANICURA","PEDICURA", "CLIENTE"};

    private JButton backButton;

    public TurnosDetails() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JToolBar toolBar = new JToolBar();
        turnosTable = new JTable();

        JScrollPane userTableScroll = new JScrollPane(turnosTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("SALIR");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    public void getTurnosJson(MapaGenerico<String, Turno> mapaTurnos) {
        ArrayList<Turno> listaDeTurnos = new ArrayList<>(mapaTurnos.devolverTodosLosValues());
        DefaultTableModel defaultTableModel = (DefaultTableModel) turnosTable.getModel();
        defaultTableModel.setColumnIdentifiers(turnosTableColumn);
        int i = 0;
        while(i < listaDeTurnos.size()) {
            String row = listaDeTurnos.get(i).displayTurno().trim();
            String[] rows = row.split(",");
            turnosTable.setAutoCreateRowSorter(true);
            turnosTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            turnosTable.getColumnModel().getColumn(1).setPreferredWidth(25);
            turnosTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }


}
