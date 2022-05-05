package Algorithm.modelo.KNN;

import Algorithm.vista.VistaInterfaceForModelo;

public class KNNModel implements KNNModelInterface{
    private VistaInterfaceForModelo vista;

    public void setVista(VistaInterfaceForModelo vista){
        this.vista = vista;
    }

}
