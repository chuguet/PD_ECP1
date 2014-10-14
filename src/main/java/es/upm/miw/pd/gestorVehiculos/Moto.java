package es.upm.miw.pd.gestorVehiculos;

import java.util.ArrayList;
import java.util.List;

public class Moto extends Vehiculo {

    private static final Integer COMIENZO_PRIMER_RANGO = 1;

    private static final Integer FIN_PRIMER_RANGO = 7;

    private static final Integer COMIENZO_SEGUNDO_RANGO = 8;

    private static final Integer FIN_SEGUNDO_RANGO = Integer.MAX_VALUE;

    private static final Double PRECIO_BASE = 8d;

    private static final Double PORCENTAJE_PAGO_PRIMER_RANGO = 1d;

    private static final Double PORCENTAJE_PAGO_SEGUNDO_RANGO = 0.875d;

    public Moto(String id, String descripcion) {
        super(id, descripcion);
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        return super.getPrecioRangos(diasAlquiler, PRECIO_BASE);
    }

    @Override
    protected List<RangoPago> getRangoPagos() {
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
}
