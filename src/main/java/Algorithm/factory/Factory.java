package Algorithm.factory;

import Algorithm.distance.Distance;
import Algorithm.distance.DistanceType;

public interface Factory {
    Distance getDistance(DistanceType distanceType);
}
