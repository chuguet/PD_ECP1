package es.upm.miw.pd.gestorVehiculos;

import upm.jbb.IO;

public class GestorVehiculos {

    private HandlerVehiculos handlerVehiculos;

    public GestorVehiculos() {
        this.handlerVehiculos = new HandlerVehiculos();
    }

    public void altaVehiculo() {
        Vehiculo vehiculo = (Vehiculo) IO.in.read(Vehiculo.class, "Introduzca un vehiculo");
        handlerVehiculos.altaVehiculo(vehiculo);
    }

    public void listarVehiculos() {
        IO.out.println("VEHICULOS:" + handlerVehiculos.listarVehiculos());
    }

    public void verPrecio() {
        String idVehiculo = IO.in.readString("Introduzca el identificador del vehiculo");
        Integer numeroDias = IO.in.readInt("Introduzca el numero de dias de alquiler");
        IO.out.println("El precio del vehiculo con id " + idVehiculo + " por un total de "
                + numeroDias + " dias es de " + handlerVehiculos.verPrecio(idVehiculo, numeroDias)
                + "€");
    }
}
