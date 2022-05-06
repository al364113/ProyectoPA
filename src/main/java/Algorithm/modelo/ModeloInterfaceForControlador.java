package Algorithm.modelo;

import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;

public interface ModeloInterfaceForControlador {
    public void creaGrafica(String ruta, String dist) throws IOException, DifferentFieldNumberInRawException;
    public void acutalizaGrafica(String x, String y);
}
