package es.upm.miw.pd.gestorVehiculos;

public abstract class Vehiculo {

    private String id;

    private String descripcion;

    public Vehiculo(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected abstract Double getPrecio(Integer diasAlquiler);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " >> ID: " + this.getId() + " DESCRIPCION: "
                + this.getDescripcion();
    }

}
