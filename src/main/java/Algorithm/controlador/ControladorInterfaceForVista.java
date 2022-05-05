package Algorithm.controlador;

import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;

public interface ControladorInterfaceForVista {
    void estimateLine();

    void creaGrafica() throws IOException, DifferentFieldNumberInRawException;

    void cambioDistancias();

    void cambiaY();

    void cambiaX();
}
