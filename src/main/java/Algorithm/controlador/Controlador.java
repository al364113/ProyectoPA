package Algorithm.controlador;

import Algorithm.modelo.ModeloInterfaceForControlador;
import Algorithm.vista.VistaInterfaceForControlador;

public class Controlador implements ControladorInterfaceForVista {
    private VistaInterfaceForControlador vista;
    private ModeloInterfaceForControlador model;


    public void setVista(VistaInterfaceForControlador vista) {
        this.vista = vista;
    }


    public void setModel(ModeloInterfaceForControlador model) {
        this.model = model;
    }

    //Falta acabar
    public void leeRuta(){
        String ruta = vista.getRuta();

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

    @Override
    public void estimateLine() {

    }
}


