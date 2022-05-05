package Algorithm.controlador;

import Algorithm.modelo.KNN.KNNModelInterface;
import Algorithm.vista.VistaInterfaceForController;

public class Controller implements ControllerInterfaceForVista {
    private VistaInterfaceForController vista;
    private KNNModelInterface model;


    @Override
    public void loadData() {

    }

    @Override
    public void estimateLine(String datos) {

    }

    public void setVista(VistaInterfaceForController vista) {
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

    //Falta acabar
    @Override
    public void cambiaX(String X) {

    }

    //Falta acabar
    @Override
    public void cambiaY(String Y) {

    }
}


