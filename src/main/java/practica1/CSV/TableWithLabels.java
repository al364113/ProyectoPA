package practica1.CSV;

import java.util.List;
import java.util.ListIterator;

public class TableWithLabels extends Table {

    public TableWithLabels(){
    }

    public TableWithLabels(List<List<String>> tabla, List<String> etiquetas){
        headers = tabla.get(0);
        for(int i = 1; i< tabla.size(); i++){
            filas.add(new RowWithLabel(tabla.get(i), etiquetas.get(i)));
        }
    }


    @Override
    public RowWithLabel getRowAt(int fila){
        return (RowWithLabel) filas.get(fila);
    }
}
