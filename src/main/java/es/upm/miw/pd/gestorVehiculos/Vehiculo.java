package es.upm.miw.pd.gestorVehiculos;

public abstract class Vehiculo {

    protected static final Integer MIN_DIAS_ALQUILER = 1;

    private String descripcion;

    private String id;

    public Vehiculo(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId() {
        return id;
    }

    protected abstract Double getPrecio(Integer diasAlquiler);

    protected Double getPrecioDosRangos(Integer diasAlquiler, Double precioBase) {
        RangoPago primerRango = new RangoPago(new Intervalo(this.getComienzoPrimerRango(),
                this.getFinPrimerRango()), this.getPorcentajePagoPrimerRango());
        RangoPago segundoRango = new RangoPago(new Intervalo(this.getComienzoSegundoRango(),
                this.getFinSegundoRango()), this.getPorcentajePagoSegundoRango());
        HandlerRangoPagos handlerRangoPagos = new HandlerRangoPagos(precioBase, primerRango,
                segundoRango);
        return handlerRangoPagos.getPrecioFinal(diasAlquiler);
    }

    protected Double getPrecioTresRangos(Integer diasAlquiler, Double precioBase) {
        RangoPago primerRango = new RangoPago(new Intervalo(this.getComienzoPrimerRango(),
                this.getFinPrimerRango()), this.getPorcentajePagoPrimerRango());
        RangoPago segundoRango = new RangoPago(new Intervalo(this.getComienzoSegundoRango(),
                this.getFinSegundoRango()), this.getPorcentajePagoSegundoRango());
        RangoPago tercerRango = new RangoPago(new Intervalo(this.getComienzoTercerRango(),
                this.getFinTercerRango()), this.getPorcentajePagoTercerRango());
        HandlerRangoPagos handlerRangoPagos = new HandlerRangoPagos(precioBase, primerRango,
                segundoRango, tercerRango);
        return handlerRangoPagos.getPrecioFinal(diasAlquiler);
    }

    protected abstract Double getPorcentajePagoPrimerRango();

    protected abstract Double getPorcentajePagoSegundoRango();

    protected abstract Double getPorcentajePagoTercerRango();

    protected abstract Integer getFinPrimerRango();

    protected abstract Integer getFinSegundoRango();

    protected abstract Integer getFinTercerRango();

    protected abstract Integer getComienzoPrimerRango();

    protected abstract Integer getComienzoSegundoRango();

    protected abstract Integer getComienzoTercerRango();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " >> ID: " + this.getId() + " DESCRIPCION: "
                + this.getDescripcion();
    }

    public Boolean esVehiculoCorrecto() {
        return this.getId() != null && !this.getId().isEmpty() && this.getDescripcion() != null
                && !this.getDescripcion().isEmpty();
    }

}
