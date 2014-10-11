package es.upm.miw.pd.operations;

import java.util.ArrayList;
import java.util.List;

public class HandlerOperations {

    private List<Operation> operators;

    public HandlerOperations() {
        this.operators = new ArrayList<Operation>();
    }

    public void add(Operation operator) {
        operators.add(operator);
    }

    public void reset() {
        operators.clear();
    }

    public int total() {
        int result = 0;
        for (Operation operation : operators) {
            result += operation.operate();
            System.out.print(operation.toString());
        }
        return result;
    }
}
