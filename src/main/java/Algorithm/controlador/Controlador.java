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

    //Falta acabarrecogeColumnas(nEtiqueta(x),nEtiqueta(y));
    @Override
    public void cambiaEjes() {
        if(vista.getBooleanXY()) {
            modelo.acutalizaGrafica(vista.getX(), vista.getY());
        }
    }


    @Override
    public void estimateLine() {

    }
}


