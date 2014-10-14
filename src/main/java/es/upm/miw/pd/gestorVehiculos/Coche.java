package es.upm.miw.pd.gestorVehiculos;

import java.util.ArrayList;
import java.util.List;

public class Coche extends Vehiculo {

    private static final Integer COMIENZO_PRIMER_RANGO = 1;

    private static final Integer FIN_PRIMER_RANGO = 3;

    private static final Integer COMIENZO_SEGUNDO_RANGO = 4;

    private static final Integer FIN_SEGUNDO_RANGO = 7;

    private static final Integer COMIENZO_TERCER_RANGO = 8;

    private static final Integer FIN_TERCER_RANGO = Integer.MAX_VALUE;

    private static final Double PRECIO_BASE_A = 10d;

    private static final Double PRECIO_BASE_B = 15d;

    private static final Double PRECIO_BASE_C = 20d;

    private static final Double PORCENTAJE_PAGO_PRIMER_RANGO = 1d;

    private static final Double PORCENTAJE_PAGO_SEGUNDO_RANGO = 0.8d;

    private static final Double PORCENTAJE_PAGO_TERCER_RANGO = 0.5d;

    public Coche(String id, String descripcion, Categoria categoria) {
        super(id, descripcion);
        this.categoria = categoria;
    }

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        RangoPago tercerRango = new RangoPago(
                new Intervalo(COMIENZO_TERCER_RANGO, FIN_TERCER_RANGO),
                PORCENTAJE_PAGO_TERCER_RANGO);
        rangoPagos.add(tercerRango);
        return rangoPagos;
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        Double precio = null;
        if (diasAlquiler < Coche.COMIENZO_PRIMER_RANGO) {
            throw new MalformedElement("El minimo de dias para alquilar es de 1");
        }
        if (this.categoria.equals(Categoria.A)) {
            precio = super.getPrecioRangos(diasAlquiler, Coche.PRECIO_BASE_A, this.getRangoPagos());
        } else if (this.categoria.equals(Categoria.B)) {
            precio = super.getPrecioRangos(diasAlquiler, Coche.PRECIO_BASE_B, this.getRangoPagos());
        } else if (this.categoria.equals(Categoria.C)) {
            precio = super.getPrecioRangos(diasAlquiler, Coche.PRECIO_BASE_C, this.getRangoPagos());
        }
        return precio;
    }
}
