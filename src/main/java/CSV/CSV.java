package CSV;

import Excepciones.DifferentFieldNumberInRawException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static Table readTable(String nombreFichero) throws IOException, DifferentFieldNumberInRawException {
        BufferedReader br = null;
        List<String> fila;
        List<List<String>> filas = new ArrayList<>();
        Table tabla = new Table();

        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line = br.readLine();
            boolean nuevaTabla = true;
            int nCols = 0;

            while (line != null) {
                fila = new ArrayList<>();
                for (String campo : line.split(",")) {
                    if (nuevaTabla) {
                        nCols++;
                    }
                    fila.add(campo);
                }
                if (fila.size() != nCols) {
                    throw new DifferentFieldNumberInRawException();
                }
                nuevaTabla = false;
                filas.add(fila);
                line = br.readLine();
            }
            tabla = new Table(filas);
        } catch (DifferentFieldNumberInRawException e) {
            throw new DifferentFieldNumberInRawException();
        } catch (Exception e) {
            System.out.println("Fallo al leer el fichero en: CSV.readTable()");
            System.out.println(e.toString());
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return tabla;
    }

    public static TableWithLabels readTableWithLabels(String nombreFichero) throws IOException, DifferentFieldNumberInRawException {
        BufferedReader br = null;
        List<String> fila;
        List<List<String>> filas = new ArrayList<>();
        List<String> etiquetas = new ArrayList<>();
        TableWithLabels tabla = new TableWithLabels();

        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String line = br.readLine();
            boolean nuevaTabla = true;
            int nCols = 0;

            while (line != null) {
                fila = new ArrayList<>();
                for (String campo : line.split(",")) {
                    if (nuevaTabla) {
                        nCols++;
                    }
                    fila.add(campo);
                }
                if (fila.size() != nCols) {
                    throw new DifferentFieldNumberInRawException();
                }
                nuevaTabla = false;
                String etiqueta = fila.remove(fila.size() - 1); //Eliminamos el último elemento de la fila para tenerlo aparte, ya que es la etiqueta.
                filas.add(fila);
                etiquetas.add(etiqueta);
                line = br.readLine();
            }
            tabla = new TableWithLabels(filas, etiquetas);


        } catch (DifferentFieldNumberInRawException e) {
            throw new DifferentFieldNumberInRawException();
        } catch (Exception e) {
            System.out.println("Fallo al leer el fichero en: CSV.readTableWithLabels()");
            System.out.println(e.toString());
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return tabla;
    }
}
