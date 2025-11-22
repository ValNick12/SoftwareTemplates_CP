package strategies;

import model.Route;

public class WalkStrategy implements TransportStrategy {
    @Override
    public boolean canTravel(Route route) {
        return route.getDistance() >= 40.0; // can't travel this distance in a day
    }

    @Override
    public double calculateTime(Route route) {
        double speed = 4.8; // km/h
        return route.getDistance() / speed;
    }

    @Override
    public double calculateCost(Route route) {
        return 0.0; // free
    }
}
