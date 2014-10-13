package es.upm.miw.pd.gestorVehiculos;

public class Bicicleta extends Vehiculo {

    private static final Integer DIAS_HASTA_SEGUNDO_TRAMO_ALQUILER = 2;

    private static final Double PRECIO_PRIMER_TRAMO = 3d;

    private static final Double PRECIO_SEGUNDO_TRAMO = 2d;

    public Bicicleta(String id, String descripcion) {
        super(id, descripcion);
    }

    @Override
    protected Double getPrecio(Integer diasAlquiler) {
        Double precio = null;
        if (diasAlquiler < MIN_DIAS_ALQUILER) {
            throw new MalformedElement("Los dias de alquiler tienen que ser mayores que 0");
        } else if (diasAlquiler <= DIAS_HASTA_SEGUNDO_TRAMO_ALQUILER
                && diasAlquiler >= MIN_DIAS_ALQUILER) {
            precio = PRECIO_PRIMER_TRAMO * diasAlquiler;
        } else {
            precio = (DIAS_HASTA_SEGUNDO_TRAMO_ALQUILER * PRECIO_PRIMER_TRAMO)
                    + ((diasAlquiler - DIAS_HASTA_SEGUNDO_TRAMO_ALQUILER) * PRECIO_SEGUNDO_TRAMO);
        }
        return precio;
    }

}
