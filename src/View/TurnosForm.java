package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;


public class TurnosForm extends JPanel {

    private DatePicker fechaPicker;
    private TimePicker horaPicker;
    private JButton addButton;
    private JButton viewButton;
    private JButton reloadClientesButton;

    private static class TiempoPermitido implements TimeVetoPolicy {

        @Override
        public boolean isTimeAllowed(LocalTime time) {
            // admite tiempo de 9am a 5pm.
            return PickerUtilities.isLocalTimeInRange(
                    time, LocalTime.of(9, 0), LocalTime.of(17, 0), true);
        }

    }

    public TurnosForm() {

        JLabel fechaLabel = new JLabel("Fecha: ");
        JLabel horarioLabel = new JLabel("Hora: ");
        JLabel clienteLabel = new JLabel("Cliente: ");
        JLabel manicuraLabel = new JLabel("Servicio de manicura: ");
        JLabel pedicuraLabel = new JLabel("Servicio de pedicura: ");
        JLabel pagosLabel = new JLabel("Medio de pago: ");

        DatePickerSettings fechaSettings = new DatePickerSettings();
        fechaPicker = new DatePicker(fechaSettings);
        TimePickerSettings horaSettings = new TimePickerSettings(Locale.getDefault());
        horaPicker = new TimePicker(horaSettings);

        addButton = new JButton("Agregar Turno");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("Ver todos los Turnos");
        viewButton.setPreferredSize(new Dimension(278, 40));
        reloadClientesButton = new JButton("Update Clientes");
        reloadClientesButton.setPreferredSize(new Dimension(125, 20));

        Insets fieldsInset = new Insets(0, 0, 10, 0);

        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.BASELINE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(fechaLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        fechaSettings.setLocale(new Locale("es", "ES"));
        fechaSettings.setDateRangeLimits(LocalDate.now(), LocalDate.MAX);
        fechaSettings.setEnableMonthMenu(true);
        fechaSettings.setVisibleClearButton(false);
        add(fechaPicker, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(horarioLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        horaSettings.setVetoPolicy(new TiempoPermitido());
        add(horaPicker, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(clienteLabel, gridBagConstraints);

        ///espacio para listado clientes

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;

        add(reloadClientesButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(manicuraLabel, gridBagConstraints);

        ///espacio para listado manicura

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(pedicuraLabel, gridBagConstraints);

        ///espacio para listado pedicura

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(pagosLabel, gridBagConstraints);

        ///espacio para listado metodos pago

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }


    public String getFecha() {
        return fechaPicker.getText();
    }
    public String getHora() {
        return horaPicker.getText();
    }


    public void verTurnos(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void submitTurno(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void updateClientesTurnos(ActionListener actionListener) {
        reloadClientesButton.addActionListener(actionListener);
    }

}
