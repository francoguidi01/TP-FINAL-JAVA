package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoDeManicura {
     NO("Sin Manicura"),GEL("Uñas de gel"), ESCULPIDA("Uñas esculpidas");

    private String tipoDeManicura;

    TipoDeManicura(String tipoDeManicura) {
        this.tipoDeManicura = tipoDeManicura;
    }

    public String getTipoDeManicura() {
        return tipoDeManicura;
    }

    public ArrayList<String> getManicuraList()
    {
        ArrayList<String> manicuras = new ArrayList<>();
        for (TipoDeManicura e : TipoDeManicura.values()) {
            manicuras.add(e.getTipoDeManicura());
        }
        return manicuras;
    }
}