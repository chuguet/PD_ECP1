package es.upm.miw.pd.gestorVehiculos;

import upm.jbb.IO;

public class GestorVehiculos {

    private HandlerVehiculos handlerVehiculos;

    public GestorVehiculos() {
        this.handlerVehiculos = new HandlerVehiculos();
    }

    public void altaCoche() {
        Coche coche = (Coche) IO.in.read(Coche.class, "Introduzca un coche");
        handlerVehiculos.altaVehiculo(coche);
    }

    public void altaMoto() {
        Moto moto = (Moto) IO.in.read(Moto.class, "Introduzca una moto");
        handlerVehiculos.altaVehiculo(moto);
    }

    public void altaBicicleta() {
        Bicicleta bicicleta = (Bicicleta) IO.in.read(Bicicleta.class, "Introduzca una bicicleta");
        handlerVehiculos.altaVehiculo(bicicleta);
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
