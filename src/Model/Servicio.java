package Model;

import Model.Cobros;

import java.io.Serializable;

public abstract class Servicio implements Cobros, Serializable {

    private Double duracion;
    public Servicio() {
        this.duracion=30.0;
    }
    public Double getDuracion() {
        return duracion;
    }
    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
