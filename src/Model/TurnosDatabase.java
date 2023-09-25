package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TurnosDatabase {
    private MapaGenerico<String, Turno> mapaTurnos;

    public TurnosDatabase() {
        mapaTurnos = new MapaGenerico<String, Turno>();
    }

    public void agregarTurno(String key, Turno turno) {
        this.mapaTurnos.agregarDatoSinRepetir(key, turno);
    }

    public void guardarMapTurnosJson(File file) {
        try {
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            save_data = gson.toJson(mapaTurnos);

            bufferedWriter.write(save_data);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MapaGenerico<String, Turno> cargarMapaDesdeJson(File file){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Type type = new TypeToken<MapaGenerico<String, Turno>>() {}.getType();
            this.mapaTurnos = new Gson().fromJson(bufferedReader, type);
            bufferedReader.close();
            return  mapaTurnos;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean comprobarKeyTurno(String key){
        return mapaTurnos.contieneLlave(key);
    }

}