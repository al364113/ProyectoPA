package Algorithm.vista;

import java.util.ArrayList;
import java.util.List;

public interface VistaInterfaceForModelo {
    public void defineLabel (String text);
    public void defineGrafica(ArrayList ejes, List<List<Double>> datos, List<String> etiquetas);
    public void actualizaGrafica(List<List<Double>> datos);
    public void nuevoPunto(Double coord1, Double coord2, String etiqueta);
}
