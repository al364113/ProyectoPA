package javafx.modelo;

import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;
import java.util.List;

public interface ModeloInterfaceForControlador {
    public void creaGrafica(String ruta, String dist) throws IOException, DifferentFieldNumberInRawException;
    public void acutalizaGrafica(String x, String y);
    public void nuevoPunto(List<Double> l);
    public void actualizaDistancia(String dist);
}
