package Controller;

import Model.*;
import View.ClientesDetails;
import View.TurnosDetails;
import View.TurnosForm;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TurnoController {
    private String turnosJson = "src\\data\\turnos.json";
    private String clientesJson = "src\\data\\clientes.json";
    private TurnosDatabase turnosDatabase;
    private ClientesDatabase clientesDatabase;
    private TurnosForm form;
    private TurnosDetails turnosDetails;
    private ClientesDetails clientesDetails;
    private JList listadoManicuras;
    private JList listadoPedicuras;
    private JList listadoPagos;
    private JList listadoClientes;

    public TurnoController(TurnosForm form, TurnosDetails turnosDetails) {

        this.turnosDatabase = new TurnosDatabase();
        this.clientesDatabase = new ClientesDatabase();
        this.form = form;
        this.turnosDetails = turnosDetails;
        this.clientesDetails = new ClientesDetails();

        MapaGenerico<String, Turno> mapa=this.turnosDatabase.cargarMapaDesdeJson(new File(turnosJson));
        ArrayList<Cliente> listaCliente =this.clientesDatabase.cargarArrayListDesdeJson(new File(clientesJson));

        listarClientes();
        listarManicuras();
        listarPedicuras();
        listarPagos();

        this.form.submitTurno(e -> {
            String fecha = this.form.getFecha().trim();
            String hora = this.form.getHora().trim();

            int indexCliente = this.listadoClientes.getSelectedIndex();
            int indexManicura = this.listadoManicuras.getSelectedIndex();
            int indexPedicura = this.listadoPedicuras.getSelectedIndex();
            int indexPago = this.listadoPagos.getSelectedIndex();

            // validaciones
            if(fecha.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Ingrese Fecha.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(hora.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Ingrese Hora.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }   else if(indexCliente==-1) {
                    JOptionPane.showMessageDialog(this.form, "Ingrese Cliente.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            } else if(indexManicura==-1) {
                JOptionPane.showMessageDialog(this.form, "Ingrese Servicio de Manicura.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(indexPedicura==-1) {
                JOptionPane.showMessageDialog(this.form, "Ingrese Servicio de Pedicura.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }  else if(indexManicura==0 && indexPedicura==0) {
                JOptionPane.showMessageDialog(this.form, "Ingrese algún servicio.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
              else if(indexPago==-1) {
                    JOptionPane.showMessageDialog(this.form, "Ingrese Medio de Pago.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }


              ServicioManicura servicioManicura = new ServicioManicura(TipoDeManicura.values()[indexManicura]);
              ServicioPedicura servicioPedicura = new ServicioPedicura(TipoDePedicura.values()[indexPedicura]);

              Factura factura = new Factura(indexPago, servicioManicura, servicioPedicura);
              factura.calcularPrecioFactura();

              Turno turno= new Turno(listaCliente.get(indexCliente), factura, fecha, hora);

            if(this.turnosDatabase.comprobarKeyTurno(turno.getKeyMapa())) {
                JOptionPane.showMessageDialog(this.form, "Ya existe turno para esa fecha y horario.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

              this.turnosDatabase.agregarTurno(turno.getKeyMapa(), turno);
              this.turnosDatabase.guardarMapTurnosJson(new File(turnosJson));

            JOptionPane.showMessageDialog(this.form, "Turno guardado correctamente: " + fecha + " a las " + hora + ", con un precio de: $"+ factura.getPrecio()+ ".", "Turno Guardado", JOptionPane.INFORMATION_MESSAGE);

        });

        // carga turno
        this.form.verTurnos(e -> {
            this.turnosDetails.getTurnosJson(this.turnosDatabase.cargarMapaDesdeJson(new File(turnosJson)));
        });

        //reload clientes turno
        this.form.updateClientesTurnos(e -> {
            ///listarClientes();
        });

    }
    public void listarClientes(){
        listadoClientes =new JList<>();

        this.clientesDetails.getClientesJson(this.clientesDatabase.cargarArrayListDesdeJson(new File(clientesJson)));
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        listadoClientes =new JList<>(this.clientesDatabase.getListaClientes().toArray());

        listadoClientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listadoClientes.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listadoClientes.setVisibleRowCount(-1);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JScrollPane listScroller = new JScrollPane(listadoClientes);
        listScroller.setPreferredSize(new Dimension(25, 80));
        this.form.add(listScroller, gridBagConstraints);
    }
    public void listarManicuras(){


        ArrayList<String> manicuras = TipoDeManicura.NO.getManicuraList();

        Insets fieldsInset = new Insets(0, 0, 10, 0);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        listadoManicuras =new JList<>(manicuras.toArray());

        listadoManicuras.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listadoManicuras.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listadoManicuras.setVisibleRowCount(-1);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = GridBagConstraints.WEST;

        this.form.add(listadoManicuras, gridBagConstraints);

    }

    public void listarPedicuras(){

        ArrayList<String> pedicuras = TipoDePedicura.NO.getPedicuraList();

        Insets fieldsInset = new Insets(0, 0, 10, 0);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        listadoPedicuras =new JList<>(pedicuras.toArray());

        listadoPedicuras.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listadoPedicuras.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listadoPedicuras.setVisibleRowCount(-1);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = GridBagConstraints.WEST;

        this.form.add(listadoPedicuras, gridBagConstraints);

    }

    public void listarPagos(){

        ArrayList<String> pagos = MedioPago.EFECTIVO.getPagosList();

        Insets fieldsInset = new Insets(0, 0, 10, 0);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        listadoPagos =new JList<>(pagos.toArray());

        listadoPagos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listadoPagos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listadoPagos.setVisibleRowCount(-1);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = GridBagConstraints.WEST;

        this.form.add(listadoPagos, gridBagConstraints);

    }


}

