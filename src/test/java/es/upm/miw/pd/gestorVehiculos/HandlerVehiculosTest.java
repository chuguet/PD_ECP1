package es.upm.miw.pd.gestorVehiculos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class HandlerVehiculosTest {

    private HandlerVehiculos handlerVehiculos;

    @Before
    public void before() {
        handlerVehiculos = new HandlerVehiculos();
        handlerVehiculos.altaVehiculo(new Coche("7777CCC", "Mi coche A", Categoria.A));
        handlerVehiculos.altaVehiculo(new Coche("8888CCC", "Mi coche B", Categoria.B));
        handlerVehiculos.altaVehiculo(new Coche("9999CCC", "Mi coche C", Categoria.C));
        handlerVehiculos.altaVehiculo(new Moto("1111MMM", "Mi moto"));
        handlerVehiculos.altaVehiculo(new Bicicleta("0000BBB", "Mi bici"));
    }

    @Test
    public void altaVehiculosTest() {
        assertEquals(new Integer(5), handlerVehiculos.numeroVehiculos());
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
        assertEquals(3, numCoches);
        assertEquals(1, numMotos);
        assertEquals(1, numBicicletas);

    }

    @Test
    public void listarVehiculosTest() {
        assertEquals("Coche >> ID: 7777CCC DESCRIPCION: Mi coche A\n"
                + "Coche >> ID: 8888CCC DESCRIPCION: Mi coche B\n"
                + "Coche >> ID: 9999CCC DESCRIPCION: Mi coche C\n"
                + "Moto >> ID: 1111MMM DESCRIPCION: Mi moto\n"
                + "Bicicleta >> ID: 0000BBB DESCRIPCION: Mi bici\n",
                handlerVehiculos.listarVehiculos());
    }

    @Test
    public void precioCocheA() {
        assertEquals(new Double(20), handlerVehiculos.verPrecio("7777CCC", 2), 10e-5);
        assertEquals(new Double(30), handlerVehiculos.verPrecio("7777CCC", 3), 10e-5);
        assertEquals(new Double(38), handlerVehiculos.verPrecio("7777CCC", 4), 10e-5);

        assertEquals(new Double(54), handlerVehiculos.verPrecio("7777CCC", 6), 10e-5);
        assertEquals(new Double(62), handlerVehiculos.verPrecio("7777CCC", 7), 10e-5);
        assertEquals(new Double(67), handlerVehiculos.verPrecio("7777CCC", 8), 10e-5);
    }

    @Test
    public void precioCocheB() {
        assertEquals(new Double(20), handlerVehiculos.verPrecio("8888CCC", 2), 10e-5);
        assertEquals(new Double(45), handlerVehiculos.verPrecio("8888CCC", 3), 10e-5);
        assertEquals(new Double(57), handlerVehiculos.verPrecio("8888CCC", 4), 10e-5);

        assertEquals(new Double(81), handlerVehiculos.verPrecio("8888CCC", 6), 10e-5);
        assertEquals(new Double(93), handlerVehiculos.verPrecio("8888CCC", 7), 10e-5);
        assertEquals(new Double(100.5), handlerVehiculos.verPrecio("8888CCC", 8), 10e-5);
    }

    @Test
    public void precioCocheC() {
        assertEquals(new Double(40), handlerVehiculos.verPrecio("9999CCC", 2), 10e-5);
        assertEquals(new Double(60), handlerVehiculos.verPrecio("9999CCC", 3), 10e-5);
        assertEquals(new Double(76), handlerVehiculos.verPrecio("9999CCC", 4), 10e-5);

        assertEquals(new Double(108), handlerVehiculos.verPrecio("9999CCC", 6), 10e-5);
        assertEquals(new Double(124), handlerVehiculos.verPrecio("9999CCC", 7), 10e-5);
        assertEquals(new Double(134), handlerVehiculos.verPrecio("9999CCC", 8), 10e-5);
    }

    @Test
    public void precioMoto() {
        assertEquals(new Double(48), handlerVehiculos.verPrecio("1111MMM", 6), 10e-5);
        assertEquals(new Double(56), handlerVehiculos.verPrecio("1111MMM", 7), 10e-5);
        assertEquals(new Double(63), handlerVehiculos.verPrecio("1111MMM", 8), 10e-5);
    }

    @Test
    public void precioBicicleta() {
        assertEquals(new Double(3), handlerVehiculos.verPrecio("0000BBB", 1), 10e-5);
        assertEquals(new Double(6), handlerVehiculos.verPrecio("0000BBB", 2), 10e-5);
        assertEquals(new Double(8), handlerVehiculos.verPrecio("0000BBB", 3), 10e-5);
    }

    @Test(expected = NoSuchElementException.class)
    public void precioNoEncontradoTest() {
        handlerVehiculos.verPrecio("12313", 1);
    }

    @Test(expected = MalformedElement.class)
    public void altaIncorrectaVehiculoTest() {
        handlerVehiculos.altaVehiculo(null);
    }

    @Test(expected = ElementAlreadyExistsException.class)
    public void elementoUnicoTest() {
        handlerVehiculos.altaVehiculo(new Coche("9999CCC", "Descripcion", Categoria.A));
    }
}
