package CSV;

import Excepciones.EmptyTableException;

import java.util.List;

public class TableWithLabels extends Table {

    public TableWithLabels() {
    }

    public TableWithLabels(List<List<String>> tabla, List<String> etiquetas) throws EmptyTableException {
        if(tabla == null || tabla.size() == 0){
            throw new EmptyTableException();
        }
        headers = tabla.get(0);
        for (int i = 1; i < tabla.size(); i++) {
            filas.add(new RowWithLabel(tabla.get(i), etiquetas.get(i)));
        }
    }


    @Override
    public RowWithLabel getRowAt(int fila) {
        return (RowWithLabel) filas.get(fila);
    }

}
