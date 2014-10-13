package es.upm.miw.pd.gestorVehiculos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HandlerVehiculos implements Iterable<Vehiculo> {

    private final List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public void altaVehiculo(Vehiculo vehiculo) {

    }

    public String listarVehiculos() {
        return null;
    }

    public Double verPrecio(String idVehiculo, Integer diasAlquiler) {
        return null;
    }

    @Override
    public Iterator<Vehiculo> iterator() {
        return null;// this.vehiculos.iterator();
    }

    public Integer numeroVehiculos() {
        return null;
    }

}
