package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientesDatabase {

    private ArrayList<Cliente> listaClientes;

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ClientesDatabase() {
        listaClientes = new ArrayList<>();
    }

    // agrega cliente a collection
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    // guarda cliente a database
    public void guardarCliente(File file) {
        try {
            // modelo cliente
            Cliente cliente;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < listaClientes.size()) {
                cliente = listaClientes.get(i);
                save_data=cliente.toString();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // lee cliente de database
    public Object[] cargaCliente(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void guardarArrayClientesJson(File file) {
        try {
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            save_data = gson.toJson(listaClientes);
            bufferedWriter.write(save_data);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> cargarArrayListDesdeJson(File file){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Type type = new TypeToken<ArrayList<Cliente>>() {}.getType();
            this.listaClientes = new Gson().fromJson(bufferedReader, type);
            bufferedReader.close();
            return listaClientes;

        } catch (IOException e) {
            e.printStackTrace();
        };
            return null;
    }

    public Cliente eliminarCliente(int index)
    {
        Cliente eliminado = listaClientes.get(index);
        listaClientes.remove(index);
        return eliminado;
    }

}