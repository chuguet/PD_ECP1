package es.upm.miw.pd.gestorVehiculos;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta extends Vehiculo {

    private static final Integer COMIENZO_PRIMER_RANGO = 1;

    private static final Integer FIN_PRIMER_RANGO = 2;

    private static final Integer COMIENZO_SEGUNDO_RANGO = 3;

    private static final Integer FIN_SEGUNDO_RANGO = Integer.MAX_VALUE;

    private static final Double PRECIO_BASE = 3d;

    private static final Double PORCENTAJE_PAGO_PRIMER_RANGO = 1d;

    private static final Double PORCENTAJE_PAGO_SEGUNDO_RANGO = 0.6666666666666666d;

    public Bicicleta(String id, String descripcion) {
        super(id, descripcion);
    }

    private List<RangoPago> getRangoPagos() {
        List<RangoPago> rangoPagos = new ArrayList<RangoPago>();
        RangoPago primerRango = new RangoPago(
                new Intervalo(COMIENZO_PRIMER_RANGO, FIN_PRIMER_RANGO),
                PORCENTAJE_PAGO_PRIMER_RANGO);
        rangoPagos.add(primerRango);
        RangoPago segundoRango = new RangoPago(new Intervalo(COMIENZO_SEGUNDO_RANGO,
                FIN_SEGUNDO_RANGO), PORCENTAJE_PAGO_SEGUNDO_RANGO);
        rangoPagos.add(segundoRango);
        return rangoPagos;
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        if (diasAlquiler < Bicicleta.COMIENZO_PRIMER_RANGO) {
            throw new MalformedElement("El minimo de dias para alquilar es de 1");
        }
        return super.getPrecioRangos(diasAlquiler, Bicicleta.PRECIO_BASE, this.getRangoPagos());
    }

}
