package Excepciones;

public class DiferentFieldsNumberInRawException extends Exception{
    public DiferentFieldsNumberInRawException(){
        super("Fila con distinto numero de columnas");
    }
}
