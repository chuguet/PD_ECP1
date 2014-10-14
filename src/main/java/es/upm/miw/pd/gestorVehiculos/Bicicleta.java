package es.upm.miw.pd.gestorVehiculos;

public class Bicicleta extends Vehiculo {

    private static final Integer COMIENZO_PRIMER_RANGO = 1;

    private static final Integer FIN_PRIMER_RANGO = 2;

    private static final Integer COMIENZO_SEGUNDO_RANGO = 3;

    private static final Integer FIN_SEGUNDO_RANGO = Integer.MAX_VALUE;

    private static final Double PRECIO_BASE = 3d;

    private static final Double PORCENTAJE_PAGO_PRIMER_RANGO = 1d;

    private static final Double PORCENTAJE_PAGO_SEGUNDO_RANGO = 0.667d;

    public Bicicleta(String id, String descripcion) {
        super(id, descripcion);
    }

    @Override
    protected Double getPorcentajePagoPrimerRango() {
        return Bicicleta.PORCENTAJE_PAGO_PRIMER_RANGO;
    }

    @Override
    protected Double getPorcentajePagoSegundoRango() {
        return Bicicleta.PORCENTAJE_PAGO_SEGUNDO_RANGO;
    }

    @Override
    protected Double getPorcentajePagoTercerRango() {
        return null;
    }

    @Override
    protected Integer getFinPrimerRango() {
        return Bicicleta.FIN_PRIMER_RANGO;
    }

    @Override
    protected Integer getFinSegundoRango() {
        return Bicicleta.FIN_SEGUNDO_RANGO;
    }

    @Override
    protected Integer getFinTercerRango() {
        return null;
    }

    @Override
    protected Integer getComienzoPrimerRango() {
        return Bicicleta.COMIENZO_PRIMER_RANGO;
    }

    @Override
    protected Integer getComienzoSegundoRango() {
        return Bicicleta.COMIENZO_SEGUNDO_RANGO;
    }

    @Override
    protected Integer getComienzoTercerRango() {
        return null;
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        if (diasAlquiler < Bicicleta.COMIENZO_PRIMER_RANGO) {
            throw new MalformedElement("El minimo de dias para alquilar es de 1");
        }
        return super.getPrecioDosRangos(diasAlquiler, Bicicleta.PRECIO_BASE);
    }

}
