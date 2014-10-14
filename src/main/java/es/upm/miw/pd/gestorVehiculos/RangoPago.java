package es.upm.miw.pd.gestorVehiculos;

public class RangoPago {

    private Intervalo intervalo;

    private Double porcentajeDePago;

    public RangoPago(Intervalo intervalo, Double porcentajedePago) {
        this.intervalo = intervalo;
        this.porcentajeDePago = porcentajedePago;
    }

    public Double getPorcentajeDePago() {
        return porcentajeDePago;
    }

    public void setPorcentajeDePago(Double porcentajeDePago) {
        this.porcentajeDePago = porcentajeDePago;
    }

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Intervalo intervalo) {
        this.intervalo = intervalo;
    }
}
