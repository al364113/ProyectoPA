package Algorithm.modelo.KNN;

import Algorithm.distance.EuclideanDistance;
import Algorithm.distance.ManhattanDistance;
import Algorithm.modelo.ModeloInterfaceForVista;
import Algorithm.modelo.ModeloInterfaceForControlador;
import Algorithm.vista.VistaInterfaceForModelo;
import CSV.CSV;
import CSV.TableWithLabels;
import Excepciones.DifferentFieldNumberInRawException;

import java.io.IOException;

public class KNNModelo implements ModeloInterfaceForVista, ModeloInterfaceForControlador {
    private VistaInterfaceForModelo vista;
    private KNN knn;
    private TableWithLabels tabla;

    public void setVista(VistaInterfaceForModelo vista){
        this.vista = vista;
    }
    @Override
    public void creaGrafica(String ruta, String dist) {
        tabla = CSV.readTableWithLabels(ruta);
        creaKNN(dist);
        knn.train(tabla);
        vista.defineGrafica(tabla.getHeaders());
    }


    private void creaKNN (String dist){
        if (dist.equals("EUCLIDEAN")) {
            knn = new KNN(new EuclideanDistance());
        } else {
            knn = new KNN(new ManhattanDistance());
        }
    }
}
