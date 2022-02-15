package practica1.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Table {
    List<String> headers = new ArrayList<String>();
    List<Row> filas = new ArrayList<Row>();

    public Table(List<List<String>> tabla){
        ListIterator<List<String>> ite = tabla.listIterator();
        headers = ite.next();
        while (ite.hasNext()){
            ListIterator<String> ite2=ite.next().listIterator();
            List<Double> aux = new ArrayList<Double>();
            while (ite2.hasNext()) aux.add(new Double(ite2.next()));
            filas.add(new Row(aux));
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
