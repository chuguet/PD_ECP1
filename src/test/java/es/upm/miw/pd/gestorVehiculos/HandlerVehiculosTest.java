package es.upm.miw.pd.gestorVehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class HandlerVehiculosTest {

    private HandlerVehiculos handlerVehiculos;

    @Before
    public void before() {
        handlerVehiculos = new HandlerVehiculos();
        handlerVehiculos.altaVehiculo(new Coche());
        handlerVehiculos.altaVehiculo(new Moto());
        handlerVehiculos.altaVehiculo(new Moto());
        handlerVehiculos.altaVehiculo(new Bicicleta());
    }

    @Test
    public void altaVehiculosTest() {
        assertEquals(new Integer(4), handlerVehiculos.numeroVehiculos());
        int numCoches = 0;
        int numMotos = 0;
        int numBicicletas = 0;

        for (Vehiculo vehiculo : handlerVehiculos) {
            if (vehiculo instanceof Coche) {
                numCoches++;
            } else if (vehiculo instanceof Moto) {
                numMotos++;
            } else if (vehiculo instanceof Bicicleta) {
                numBicicletas++;
            } else {
                fail("Vehiculo no reconocido");
            }
        }
        assertEquals(1, numCoches);
        assertEquals(2, numMotos);
        assertEquals(1, numBicicletas);

    }

    @Test
    public void listarVehiculosTest() {
        assertEquals("", handlerVehiculos.listarVehiculos());
    }

    @Test
    public void precioVehiculo() {
        assertEquals(new Double(34.3), handlerVehiculos.verPrecio("4232FMM", 3));
    }
}
