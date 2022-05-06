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
import java.util.ArrayList;
import java.util.List;

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
        vista.defineGrafica(tabla.getHeaders(),recogeColumnas(1, 0), tabla.getEtiquetas());
    }

    public void acutalizaGrafica(String x, String y){
        int nX=nEtiqueta(x);
        int nY=nEtiqueta(y);
        vista.actualizaGrafica(recogeColumnas(nX,nY));
    }

    private void creaKNN (String dist){
        if (dist.equals("EUCLIDEAN")) {
            knn = new KNN(new EuclideanDistance());
        } else {
            knn = new KNN(new ManhattanDistance());
        }
    }

    private List<List<Double>> recogeColumnas(int x, int y){
        List<List<Double>> list = new ArrayList<>();
        list.add(tabla.getColumAt(x));
        list.add(tabla.getColumAt(y));
        return list;
    }

    private int nEtiqueta (String nombre){
        return tabla.getHeaders().indexOf(nombre);
    }


}
