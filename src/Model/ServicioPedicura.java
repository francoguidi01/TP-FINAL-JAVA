package Model;

public class ServicioPedicura extends Servicio {

    private TipoDePedicura tipo;

    public ServicioPedicura(TipoDePedicura tipo) {
        this.tipo = tipo;
    }

    public TipoDePedicura getTipo() {
        return tipo;
    }

    @Override
    public Double calcularPrecio() {
        double precio = 0;
        if (this.getTipo() == TipoDePedicura.ESTANDAR) {
            precio = 200.0;
        } else if (this.getTipo() == TipoDePedicura.PREMIUM) {
            precio = 1000.0;
        }
        return precio;
    }
}
