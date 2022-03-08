package Algorithm;

import CSV.Table;

public interface Algorithm {
    public <T extends Table> void Train(T tabla);
    public <T, U> U estimate(T sample);

}
