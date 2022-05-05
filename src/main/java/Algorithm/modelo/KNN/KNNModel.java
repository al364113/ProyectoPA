package Algorithm.modelo.KNN;

import Algorithm.vista.VistaInterfaceForController;

public class KNNModel implements KNNModelInterface{
    private VistaInterfaceForController vista;

    public void setVista(VistaInterfaceForController vista){
        this.vista = vista;
    }

}
