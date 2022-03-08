package Algorithm;

import CSV.Table;

public interface Algorithm<T extends  Table,U,J> {
    public void train(T tabla);
    public U estimate(J sample);

}
