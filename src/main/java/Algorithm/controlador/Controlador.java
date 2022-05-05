package Algorithm.controlador;

import Algorithm.modelo.KNN.KNNModelInterface;
import Algorithm.vista.VistaInterfaceForControlador;

public class Controlador implements ControladorInterfaceForVista {
    private VistaInterfaceForControlador vista;
    private KNNModelInterface model;


    @Override
    public void loadData() {

    }

    @Override
    public void estimateLine() {

    }

    public void setVista(VistaInterfaceForControlador vista) {
        this.vista = vista;
    }


    public void setModel(KNNModelInterface model) {
        this.model = model;
    }

    //Falta acabar
    public void leeRuta(){

    }

    //Falta acabar
    public void cambioDistancias(){

    }

    //Falta acabar
    @Override
    public void cambiaX() {

    }

    //Falta acabar
    @Override
    public void cambiaY() {

    }
}


