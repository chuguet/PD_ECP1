package es.upm.miw.pd.gestorVehiculos;

import java.util.Arrays;
import java.util.List;

public class HandlerRangoPagos {

    private Double precioBase;

    private List<RangoPago> rangoPagos;

    public HandlerRangoPagos(Double precioBase, RangoPago... rangoPagos) {
        this.precioBase = precioBase;
        this.rangoPagos = Arrays.asList(rangoPagos);
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public List<RangoPago> getRangoPagos() {
        return rangoPagos;
    }

    public void setRangoPagos(List<RangoPago> rangoPagos) {
        this.rangoPagos = rangoPagos;
    }

    public Double getPrecioFinal(Integer diasAlquiler) {
        Double precioFinal = 0d;
        for (RangoPago rangoPago : rangoPagos) {
            if (rangoPago.getIntervalo().below(diasAlquiler)) {
                precioFinal += precioFinal
                        + (rangoPago.getPorcentajeDePago() * this.getPrecioBase() * rangoPago
                                .getIntervalo().evaluate(diasAlquiler));
                break;
            } else {
                precioFinal += precioFinal
                        + (rangoPago.getPorcentajeDePago() * this.getPrecioBase() * rangoPago
                                .getIntervalo().getMax());
            }
        }
        return precioFinal;
    }
}
