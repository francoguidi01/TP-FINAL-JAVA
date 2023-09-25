package Model;

import java.io.Serializable;
import java.util.Scanner;

public class Factura implements Serializable  {
    private Double precio;
    private MedioPago medioPago;
    private ServicioPedicura pedicura;
    private ServicioManicura manicura;

    public ServicioPedicura getPedicura() {
        return pedicura;
    }

    public void setPedicura(ServicioPedicura pedicura) {
        this.pedicura = pedicura;
    }

    public ServicioManicura getManicura() {
        return manicura;
    }

    public void setManicura(ServicioManicura manicura) {
        this.manicura = manicura;
    }

    public Factura(int indexPago, ServicioManicura servicioManicura, ServicioPedicura servicioPedicura) {
        this.medioPago = MedioPago.values()[indexPago];
        this.pedicura = servicioPedicura;
        this.manicura = servicioManicura;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "precio=" + precio +
                ", medioPago=" + medioPago +
                ", pedicura=" + pedicura.getTipo().getTipoDePedicura() +
                ", manicura=" + manicura.getTipoDeManicura().getTipoDeManicura() +
                '}';
    }

    public void calcularPrecioFactura() {

        double precioFactura =manicura.calcularPrecio()+pedicura.calcularPrecio() ;

        int flag = 0;

        while (flag == 0) {
            try {
                switch (this.medioPago) {
                    case TARJETA:
                        precioFactura *= 1.1;
                        flag = 1;
                        break;
                    case TRANSFERENCIA:
                        precioFactura *= 1.05;
                        flag = 1;
                        break;
                    case EFECTIVO:
                        precioFactura *= 0.95;
                        flag = 1;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Método de pago inválido. (Creando Factura)");
            }

        }
            this.precio=precioFactura;
    }

    public String getTipoManicura(){
        return manicura.getTipoDeManicura().getTipoDeManicura();
    }
    public String getTipoPedicura(){
        return pedicura.getTipo().getTipoDePedicura();
    }
}

