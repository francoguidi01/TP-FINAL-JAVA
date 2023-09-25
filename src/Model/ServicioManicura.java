package Model;

public class ServicioManicura extends Servicio{

private TipoDeManicura tipoDeManicura;


    public ServicioManicura(TipoDeManicura tipoDeManicura) {
        this.tipoDeManicura = tipoDeManicura;
    }

    public TipoDeManicura getTipoDeManicura() {
        return tipoDeManicura;
    }

    @Override
    public Double calcularPrecio() {
        double precio = 0;
        if (this.getTipoDeManicura() == TipoDeManicura.GEL) {
            precio = 500.0;
        } else if (this.getTipoDeManicura() == TipoDeManicura.ESCULPIDA) {
            precio = 400.0;
        }
        return precio;
    }

}
