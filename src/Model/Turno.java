package Model;

import Model.Cliente;
import Model.Factura;

import java.io.Serializable;
import java.time.LocalDate;

public class Turno implements Serializable {
    private Cliente cliente;
    private Factura factura;
    private String fecha;
    private String horario;


    //todo 1)Una lista con fechas por dias por ejemplo de lunes a viernes cuando se agrega un nuevo turno
    // se elimina del lista y añade al atributo fecha de la clase turno.

    public Turno(Cliente cliente, Factura factura, String fecha, String horario) {
        this.cliente = cliente;
        this.factura = factura;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Turno() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "cliente=" + cliente +
                ", factura=" + factura +
                ", fecha='" + fecha + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

    public String displayTurno() {
        return
                fecha +
                        "," + horario +
                        "," + factura.getPrecio()+
                        "," + factura.getManicura().getTipoDeManicura().getTipoDeManicura()+
                        "," + factura.getPedicura().getTipo().getTipoDePedicura()+
                        "," + cliente.getNombre()+" "+cliente.getApellido();
    }

    public String getKeyMapa(){
        String key = this.fecha+" "+this.horario;
        return key;
    }

//    public void descuentoDeTurnos()
//    {
//        if(cliente.verificarTurnosCliente())
//        {
//            System.out.println("Precio: " + factura.getPrecio());
//            factura.setPrecio(factura.getPrecio()*0.8);
//            System.out.println("Precio: " + factura.getPrecio());
//        }
//        else {System.out.println("Probando no hay 20 turnos papafrita");}
//    }
}
