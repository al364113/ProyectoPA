package Algorithm.factory;

import Algorithm.distance.Distance;
import Algorithm.distance.DistanceType;
import Algorithm.distance.EuclideanDistance;
import Algorithm.distance.ManhattanDistance;

public class DistanceFactory implements Factory{
    @Override
    public Distance getDistance(DistanceType distanceType) {
        Distance distance;
        switch(distanceType){
            case EUCLIDEAN:
                distance = new EuclideanDistance();
                break;
            case MANHATTAM:
                distance = new ManhattanDistance();
                break;
            default:
                distance = null;
        }
        return distance;


    }
}
