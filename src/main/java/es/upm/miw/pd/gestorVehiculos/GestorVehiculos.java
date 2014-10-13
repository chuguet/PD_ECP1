package es.upm.miw.pd.gestorVehiculos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import upm.jbb.IO;

public class GestorVehiculos {

    private Logger LOG = LogManager.getLogger(GestorVehiculos.class);

    private HandlerVehiculos handlerVehiculos;

    public GestorVehiculos() {
        this.handlerVehiculos = new HandlerVehiculos();
    }

    private void altaVehiculo(Vehiculo vehiculo) {
        try {
            handlerVehiculos.altaVehiculo(vehiculo);
        } catch (ElementAlreadyExistsException e) {
            IO.out.println("El vehiculo con el id introducido ya existe");
            LOG.error(e.getMessage());
        } catch (MalformedElement e) {
            IO.out.println("Se debe introducir los datos del vehiculo correctamente");
            LOG.error(e.getMessage());
        }
    }

    public void altaCoche() {
        Coche coche = (Coche) IO.in.read(Coche.class, "Introduzca un coche");
        this.altaVehiculo(coche);

    }

    public void altaMoto() {
        Moto moto = (Moto) IO.in.read(Moto.class, "Introduzca una moto");
        this.altaVehiculo(moto);
    }

    public void altaBicicleta() {
        Bicicleta bicicleta = (Bicicleta) IO.in.read(Bicicleta.class, "Introduzca una bicicleta");
        this.altaVehiculo(bicicleta);
    }

    public void listarVehiculos() {
        IO.out.println("VEHICULOS:" + handlerVehiculos.listarVehiculos());
    }

    public void verPrecio() {
        String idVehiculo = IO.in.readString("Introduzca el identificador del vehiculo");
        Integer numeroDias = IO.in.readInt("Introduzca el numero de dias de alquiler");
        try {
            IO.out.println("El precio del vehiculo con id " + idVehiculo + " por un total de "
                    + numeroDias + " dias es de "
                    + handlerVehiculos.verPrecio(idVehiculo, numeroDias) + "€");
        } catch (NoSuchElementException e) {
            IO.out.println("El vehiculo con ese id no existe");
            LOG.error(e.getMessage());
        }

    }
}
