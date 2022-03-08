package Excepciones;

public class DifferentFieldNumberInRawException extends Exception{
    public DifferentFieldNumberInRawException(){
        super("Fila con distinto numero de columnas");
    }
}
