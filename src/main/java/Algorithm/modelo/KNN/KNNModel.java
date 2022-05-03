package Algorithm.modelo.KNN;

import Algorithm.vista.KNNVistaInterface;

public class KNNModel implements KNNModelInterface{
    private KNNVistaInterface vista;

    public void setVista(KNNVistaInterface vista){
        this.vista = vista;
    }

}
