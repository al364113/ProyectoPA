package Algorithm;

import CSV.Table;
import Excepciones.ZeroDivisionExeption;

public interface Algorithm<T extends  Table,U,J> {
    public void train(T tabla) throws ZeroDivisionExeption;
    public U estimate(J sample);

}
