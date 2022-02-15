package practica1.CSV;

public class TableWithLabels extends Table {

    @Override
    public RowWithLabel getRowAt(int n_fila){
        return filas.get(n_fila);
    }
}
