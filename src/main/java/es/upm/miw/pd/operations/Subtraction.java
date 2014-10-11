package es.upm.miw.pd.operations;

public class Subtraction extends Operation {

    public Subtraction(final int operator1, final int operator2) {
        super(operator1, operator2);
    }

    @Override
    public int operate() {
        return this.operator1 - this.operator2;
    }

    @Override
    public String toString() {
        return "[" + operator1 + "-" + operator2 + "]";
    }

}
