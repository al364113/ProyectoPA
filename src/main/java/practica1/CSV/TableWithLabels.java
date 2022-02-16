package practica1.CSV;

import java.util.List;
import java.util.ListIterator;

public class TableWithLabels extends Table {

    public TableWithLabels(){
    }

    public TableWithLabels(List<List<String>> tabla){
        ListIterator<List<String>> ite = tabla.listIterator();
        headers=ite.next();
        while (ite.hasNext()){
            filas.add(new RowWithLabel(ite.next()));
        }
    }


    @Override
    public RowWithLabel getRowAt(int fila){
        return (RowWithLabel) filas.get(fila); //TODO ¿Cast?
    }
}
