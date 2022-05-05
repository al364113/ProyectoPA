package Algorithm.modelo.KNN;

import Algorithm.modelo.ModeloInterfaceForVista;
import Algorithm.modelo.ModeloInterfaceForControlador;
import Algorithm.vista.VistaInterfaceForModelo;

public class KNNModelo implements ModeloInterfaceForVista, ModeloInterfaceForControlador {
    private VistaInterfaceForModelo vista;

    public void setVista(VistaInterfaceForModelo vista){
        this.vista = vista;
    }

}
