package es.upm.miw.pd.gestorVehiculos;

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

    @Override
    protected Double getPorcentajePagoPrimerRango() {
        return Coche.PORCENTAJE_PAGO_PRIMER_RANGO;
    }

    @Override
    protected Double getPorcentajePagoSegundoRango() {
        return Coche.PORCENTAJE_PAGO_SEGUNDO_RANGO;
    }

    @Override
    protected Double getPorcentajePagoTercerRango() {
        return Coche.PORCENTAJE_PAGO_TERCER_RANGO;
    }

    @Override
    protected Integer getFinPrimerRango() {
        return Coche.FIN_PRIMER_RANGO;
    }

    @Override
    protected Integer getFinSegundoRango() {
        return Coche.FIN_SEGUNDO_RANGO;
    }

    @Override
    protected Integer getFinTercerRango() {
        return Coche.FIN_TERCER_RANGO;
    }

    @Override
    protected Integer getComienzoPrimerRango() {
        return Coche.COMIENZO_PRIMER_RANGO;
    }

    @Override
    protected Integer getComienzoSegundoRango() {
        return Coche.COMIENZO_SEGUNDO_RANGO;
    }

    @Override
    protected Integer getComienzoTercerRango() {
        return Coche.COMIENZO_TERCER_RANGO;
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        Double precio = null;
        if (diasAlquiler < Coche.COMIENZO_PRIMER_RANGO) {
            throw new MalformedElement("El minimo de dias para alquilar es de 1");
        }
        if (this.categoria.equals(Categoria.A)) {
            precio = super.getPrecioTresRangos(diasAlquiler, Coche.PRECIO_BASE_A);
        } else if (this.categoria.equals(Categoria.B)) {
            precio = super.getPrecioTresRangos(diasAlquiler, Coche.PRECIO_BASE_B);
        } else if (this.categoria.equals(Categoria.C)) {
            precio = super.getPrecioTresRangos(diasAlquiler, Coche.PRECIO_BASE_C);
        }
        return precio;
    }
}
