package Algorithm.KNN.modelo;

import Algorithm.KNN.vista.KNNVistaInterface;

public class KNNModel implements KNNModelInterface{
    private KNNVistaInterface vista;

    public void setVista(KNNVistaInterface vista){
        this.vista = vista;
    }

}
