package Algorithm.KNN.controlador;

import Algorithm.KNN.modelo.KNNModelInterface;
import Algorithm.KNN.vista.KNNVistaInterface;

public class KNNController implements KNNControllerInterface{
    private KNNVistaInterface vista;
    private KNNModelInterface model;


    @Override
    public void loadData() {

    }

    @Override
    public void estimateLine() {

    }

    public void setVista(KNNVistaInterface vista) {
        this.vista = vista;
    }


    public void setModel(KNNModelInterface model) {
        this.model = model;
    }
}
