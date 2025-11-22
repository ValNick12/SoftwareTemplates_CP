package strategies;

import model.Route;

public class BikeStrategy implements TransportStrategy {
    @Override
    public boolean canTravel(Route route) {
        return route.getTransportFactory().hasBikeLanes();
    }

    @Override
    public double calculateTime(Route route) {
        double speed = 15.0; // km/h
        return route.getDistance() / speed;
    }

    @Override
    public double calculateCost(Route route) {
        return 0.0; // free
    }
}
