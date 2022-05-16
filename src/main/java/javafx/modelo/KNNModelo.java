package javafx.modelo;

import Algorithm.distance.EuclideanDistance;
import Algorithm.distance.ManhattanDistance;
import Algorithm.KNN.KNN;
import javafx.vista.VistaInterfaceForModelo;
import CSV.CSV;
import CSV.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class KNNModelo implements ModeloInterfaceForVista, ModeloInterfaceForControlador {
    private VistaInterfaceForModelo vista;
    private KNN knn;
    private TableWithLabels tabla;
    private int nX = 1, nY = 0;
    private List<Double> punto = null;
    private String etiqueta;

    public void setVista(VistaInterfaceForModelo vista){
        this.vista = vista;
    }
    @Override
    public void creaGrafica(String ruta, String dist) {
        tabla = CSV.readTableWithLabels(ruta);
        creaKNN(dist);
        knn.train(tabla);
        vista.defineGrafica(tabla.getHeaders(),recogeColumnas(nX, nY), tabla.getEtiquetas());
    }

    public void acutalizaGrafica(String x, String y){
        nX=nEtiqueta(x);
        nY=nEtiqueta(y);
        vista.actualizaGrafica(recogeColumnas(nX,nY));
        if(punto != null){
            vista.nuevoPunto(punto.get(nX), punto.get(nY), etiqueta);
        }
    }

    @Override
    public void actualizaDistancia(String dist){
        creaKNN(dist);
        knn.train(tabla);
        if(punto != null) {
            actualizaPunto();
        }
    }

    private void creaKNN (String dist){
        if (dist.equals("EUCLIDEAN")) {
            knn = new KNN(new EuclideanDistance());
        } else {
            knn = new KNN(new ManhattanDistance());
        }
    }

    //Recoge los datos de la columna
    private List<List<Double>> recogeColumnas(int x, int y){
        List<List<Double>> list = new ArrayList<>();
        list.add(tabla.getColumAt(x));
        list.add(tabla.getColumAt(y));
        return list;
    }

    //Recoge el índice de la etiqueta
    private int nEtiqueta (String nombre){
        return tabla.getHeaders().indexOf(nombre);
    }


    public void nuevoPunto(List<Double> punto){
        this.punto = punto;
        actualizaPunto();
    }

    private void actualizaPunto(){
        etiqueta = knn.estimate(punto);
        vista.nuevoPunto(punto.get(nX), punto.get(nY), etiqueta);
    }

}
