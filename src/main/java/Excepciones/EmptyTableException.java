package Excepciones;

public class EmptyTableException extends Exception{
    public EmptyTableException(){
        super("La tabla está vacía.");
    }
}
