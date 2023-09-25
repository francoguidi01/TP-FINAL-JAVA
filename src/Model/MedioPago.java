package Model;

import java.io.Serializable;
import java.util.ArrayList;

public enum MedioPago implements Serializable {
    TARJETA ("Tarjeta (x1.1)"), EFECTIVO ("Efectivo (x0.95)"), TRANSFERENCIA ("Mercado Pago (x1.05)");

    private String medioPago;

    MedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public ArrayList<String> getPagosList()
    {
        ArrayList<String> pagos = new ArrayList<>();
        for (MedioPago e : MedioPago.values()) {
            pagos.add(e.getMedioPago());
        }
        return pagos;
    }

}
