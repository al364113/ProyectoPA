package practica1.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Table {
    List<String> headers = new ArrayList<String>();
    List<Row> filas = new ArrayList<Row>();

    public Table(List<String> headers,List<List<Double>> tabla){
        this.headers = headers;
        ListIterator<List<Double>> ite = tabla.listIterator();
        while (ite.hasNext()){
            filas.add(new Row(ite.next()));
        }
    }

    public Row getRow(int n_fila){
        return filas.get(n_fila);
    }

    public List<Double> getColumAt(int n_columna){
        ListIterator<Row> filas_iterator = filas.listIterator();
        List<Double> columna= new ArrayList<Double>();
        while (filas_iterator.hasNext()){
            List<Double> fila = filas_iterator.next().getData();
            columna.add(fila.get(n_columna));
        }
        return columna;
    }
}
