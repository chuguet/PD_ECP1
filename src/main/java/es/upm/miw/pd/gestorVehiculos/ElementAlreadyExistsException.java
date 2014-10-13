package es.upm.miw.pd.gestorVehiculos;

public class ElementAlreadyExistsException extends GestorVehiculosException {

    private static final long serialVersionUID = -4661610976850544584L;

    public ElementAlreadyExistsException(String msg) {
        super(msg);
    }

}
