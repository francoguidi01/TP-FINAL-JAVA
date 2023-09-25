package Model;


import java.util.*;

public class MapaGenerico<K, V> {

    //K = KEY
    //V = VALUE todo asi mejor
    Map<K, V> mapita = new HashMap<>();

    public MapaGenerico() {
        this.mapita = new HashMap<>();
    }

    public Boolean agregarDatoSinRepetir(K k, V v) {
        if (!mapita.containsKey(k)) {
            mapita.put(k, v);
            return true;
        }
        return false;
    }

    public Boolean eliminarDelMapa(K k) {
        if (mapita.remove(k) != null)
            return true;
        else {
            return false;
        }
    }

    public V devolverValue(K k) {
        return mapita.get(k);
    }

    public Boolean contieneLlave(K k) {
        return mapita.containsKey(k);
    }

    public Integer tamanioDelMapa() {
        return mapita.size();
    }

    public Boolean verficarSiEstaVacioElMapa() {
        return mapita.isEmpty();
    }

    //todo haces un set con las llaves del mapa
    public Set<K> keySet() {
        return mapita.keySet();
    }

    //todo te devuelve todos los values del mapa en un objeto que es collection, se puede hacer con un set tambien
    public Collection<V> devolverTodosLosValues() {
        return mapita.values();
    }

    //todo cuidado con usar esto eh. Porque se borran los repetidos.
    public Set<V> pasarTodoValuesAUnSet() {
        Collection<V> value = this.devolverTodosLosValues();
        Set<V> set = new HashSet<>(value);
        return set;
    }

    public void recorrerElMapitaYVerLasKeys() {
        for (Map.Entry<K, V> entry2 : mapita.entrySet()) {
            K key = entry2.getKey();
            System.out.println(" -> " + key);
        }
    }

}
