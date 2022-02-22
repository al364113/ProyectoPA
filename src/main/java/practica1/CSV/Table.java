package practica1.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Table {
    List<String> headers = new ArrayList<String>();
    List<Row> filas = new ArrayList<Row>();

    public Table() {
    }

    public Table(List<List<String>> tabla){
        ListIterator<List<String>> ite = tabla.listIterator();
        headers=ite.next();
        while (ite.hasNext()){
            filas.add(new Row(ite.next()));
        }
    }

    public Row getRowAt(int nFila){
        return filas.get(nFila);
    }

    public List<Double> getColumAt(int nColumna){
        ListIterator<Row> filas_iterator = filas.listIterator();
        List<Double> columna= new ArrayList<Double>();
        while (filas_iterator.hasNext()){
            List<Double> fila = filas_iterator.next().getData();
            columna.add(fila.get(nColumna));
        }
        return columna;
    }
    public int size(){
        return filas.size() + 1;
    }

    public int rowSize() { return headers.size(); }

}
