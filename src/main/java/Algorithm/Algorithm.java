package Algorithm;

import CSV.Table;

public interface Algorithm {
    public <T extends Table> void Train(T tabla);

}
