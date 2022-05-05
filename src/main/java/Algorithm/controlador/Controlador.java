package Algorithm.controlador;

import Algorithm.modelo.ModeloInterfaceForControlador;
import Algorithm.vista.VistaInterfaceForControlador;
import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;

public class Controlador implements ControladorInterfaceForVista {
    private VistaInterfaceForControlador vista;
    private ModeloInterfaceForControlador modelo;


    public void setVista(VistaInterfaceForControlador vista) {
        this.vista = vista;
    }


    public void setModelo(ModeloInterfaceForControlador modelo) {
        this.modelo = modelo;
    }

    public void creaGrafica() throws IOException, DifferentFieldNumberInRawException {
        String ruta = vista.getRuta();
        String dist = vista.getTipoDist();
        modelo.creaGrafica(ruta,dist);
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


