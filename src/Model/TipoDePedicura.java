package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoDePedicura {

    NO ("Sin pedicura"), ESTANDAR("Estándar"), PREMIUM("Premium (Masaje con piedras)");

    private String tipoDePedicura;

    TipoDePedicura(String tipoDePedicura) {
        this.tipoDePedicura = tipoDePedicura;
    }

    public String getTipoDePedicura() {
        return tipoDePedicura;
    }

    public ArrayList<String> getPedicuraList()
    {
        ArrayList<String> pedicuras = new ArrayList<>();
        for (TipoDePedicura e : TipoDePedicura.values()) {
            pedicuras.add(e.getTipoDePedicura());
        }
        return pedicuras;
    }
}
