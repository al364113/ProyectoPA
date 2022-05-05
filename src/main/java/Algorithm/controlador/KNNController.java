package Algorithm.controlador;

import Algorithm.modelo.KNN.KNN;
import Algorithm.modelo.KNN.KNNModelInterface;
import Algorithm.vista.KNNVistaInterface;

public class KNNController implements KNNControllerInterface{
    private KNNVistaInterface vista;
    private KNNModelInterface model;


    @Override
    public void loadData() {

    }

    @Override
    public void estimateLine(String datos) {

    }

    public void setVista(KNNVistaInterface vista) {
        this.vista = vista;
    }


    public void setModel(KNNModelInterface model) {
        this.model = model;
    }

    //Falta acabar
    public void leeRuta(String ruta){

    }

    //Falta acabar
    public void cambioDistancias(String dist){

    }
}


