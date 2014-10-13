package es.upm.miw.pd.gestorVehiculos;

public class Coche extends Vehiculo {

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
    protected Double getPrecio(Integer diasAlquiler) {
        return null;
    }
}
