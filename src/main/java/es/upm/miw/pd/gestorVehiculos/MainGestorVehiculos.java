package es.upm.miw.pd.gestorVehiculos;

import upm.jbb.IO;

public class MainGestorVehiculos {

    public static void main(String[] args) {
        IO.in.addController(new GestorVehiculos());
    }

}
