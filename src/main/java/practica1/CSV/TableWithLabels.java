package practica1.CSV;

import java.util.List;
import java.util.ListIterator;

public class TableWithLabels extends Table {

    public TableWithLabels(){
    }

    public TableWithLabels(List<List<String>> tabla, List<String> etiquetas){
        /*ListIterator<List<String>> ite = tabla.listIterator();
        headers=ite.next();
        while (ite.hasNext()){
            filas.add(new RowWithLabel(ite.next()));
        }*/

        headers = tabla.get(0);
        for(int i = 1; i< tabla.size(); i++){
            filas.add(new RowWithLabel(tabla.get(1), etiquetas.get(1)));

        }
    }


    @Override
    public RowWithLabel getRowAt(int fila){
        return (RowWithLabel) filas.get(fila); //TODO ¿Cast?
    }
}
