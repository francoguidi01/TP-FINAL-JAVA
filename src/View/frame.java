package View;

import Controller.ClienteController;
import Controller.TurnoController;

import javax.swing.*;
import java.awt.*;

public class frame extends JFrame {

    private CardLayout cardLayout;

    public frame() {
        super("JP+ NAIL SALON");

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        ClientesForm clientesForm = new ClientesForm();
        ClientesDetails clientesDetails = new ClientesDetails();
        new ClienteController(clientesForm, clientesDetails);

        TurnosForm turnosForm = new TurnosForm();
        TurnosDetails turnosDetails = new TurnosDetails();
        new TurnoController(turnosForm, turnosDetails);

        JTabbedPane tabPanel = new JTabbedPane();

        add(tabPanel, "tab");

        add(clientesForm, "clientesForm");
        add(clientesDetails, "clientes details");

        add(turnosForm, "turnosForm");
        add(turnosDetails, "turnos details");

        clientesForm.verClientes(e -> clientesDetails.reset());
        clientesForm.verClientes(e -> cardLayout.show(frame.this.getContentPane(), "clientes details"));
        clientesDetails.backButton(e -> cardLayout.show(frame.this.getContentPane(), "tab"));

        clientesDetails.eliminarButton(e -> cardLayout.show(frame.this.getContentPane(), "tab"));


        turnosForm.verTurnos(e -> cardLayout.show(frame.this.getContentPane(), "turnos details"));
        turnosDetails.backButton(e -> cardLayout.show(frame.this.getContentPane(), "tab"));

        tabPanel.addTab("CLIENTES", clientesForm);
        tabPanel.addTab("TURNOS", turnosForm);

        ImageIcon imageIcon = new ImageIcon("src/assets/jp+.png");
        setIconImage(imageIcon.getImage());

        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }




}
