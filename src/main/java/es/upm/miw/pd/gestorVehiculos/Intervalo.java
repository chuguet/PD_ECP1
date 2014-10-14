package es.upm.miw.pd.gestorVehiculos;

public class Intervalo {

    private Integer min;

    private Integer max;

    public Intervalo(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Boolean below(Integer number) {
        return number <= this.max && number >= this.min;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer evaluate(Integer diasAlquiler) {
        return diasAlquiler - this.min + 1;
    }

}
