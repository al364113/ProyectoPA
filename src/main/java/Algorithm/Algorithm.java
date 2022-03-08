package Algorithm;

import CSV.Table;

public interface Algorithm<T,U,J> {
    public void train(T tabla);
    public U estimate(J sample);

}
