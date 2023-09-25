package Model;

import java.io.Serializable;
import java.util.UUID;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private String idCliente;
    private Integer turnosAcumulados=40;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTurnosAcumulados() {
        return turnosAcumulados;
    }

    public void setTurnosAcumulados(Integer turnosAcumulados) {
        this.turnosAcumulados = turnosAcumulados;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idCliente = UUID.randomUUID().toString().substring(0, 7);
    }


    public String displayCliente() {
        return
                nombre +
                ", " +apellido +
                ", " + telefono +
                ", " + idCliente;
    }

    @Override
    public String toString() {
        return
                nombre +" " + apellido + " tel. " + telefono;
    }

    private String formatSpaces(String text, int spaces) {
        StringBuilder sb = new StringBuilder();
        int remainingSpaces = spaces - text.length();
        for (int i = 0; i < remainingSpaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


}
