package Algorithm.controlador;

import Algorithm.modelo.ModeloInterfaceForControlador;
import Algorithm.vista.VistaInterfaceForControlador;
import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void cambioDistancias(){
       modelo.actualizaDistancia(vista.getTipoDist());
    }

    @Override
    public void cambiaEjes() {
        if(vista.getBooleanXY()) {
            modelo.acutalizaGrafica(vista.getX(), vista.getY());
        }
    }


    @Override
    public void estimateLine() {
        modelo.nuevoPunto(cadenaADouble(vista.getPunto()));
    }

    private List<Double> cadenaADouble(String punto){
        List<Double> lista = new ArrayList<>();
        for(String coord: punto.split(",")){
            lista.add(new Double(coord));
        }
        return lista;
    }
}


