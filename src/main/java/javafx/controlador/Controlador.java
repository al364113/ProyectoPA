package javafx.controlador;

import Excepciones.NullPointException;
import javafx.modelo.ModeloInterfaceForControlador;
import javafx.vista.VistaInterfaceForControlador;
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

        try {
            List<Double> coordenadas = cadenaADouble(vista.getPunto());
            if (esPuntoValido(coordenadas)){
                modelo.nuevoPunto(coordenadas);
            }else{
                System.out.println("Punto no valido.");
            }
        }catch (NullPointException e){
            System.out.println(e.getMessage());
        }

    }

    private boolean esPuntoValido(List<Double> coordenadas){
        boolean valido = true;
        int cont = 0;
        for(Double d: coordenadas){
            if (d < 0){
                valido = false;
                break;
            }
            cont++;
        }
        if(cont != 4){
            valido = false;
        }
        return valido;
    }

    private List<Double> cadenaADouble(String punto) throws NullPointException{

        try {
            List<Double> lista = new ArrayList<>();
            for (String coord : punto.split(",")) {
                lista.add(new Double(coord));
            }
            return lista;
        }catch (NumberFormatException e){
            throw new NullPointException();
        }
    }
}


