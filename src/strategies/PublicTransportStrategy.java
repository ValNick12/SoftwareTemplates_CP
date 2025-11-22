package strategies;

import model.Route;

public class PublicTransportStrategy implements TransportStrategy {

    private double speed;

    public PublicTransportStrategy (double speed) {
        this.speed = speed;
    }

    @Override
    public boolean canTravel(Route route) {
        return route.hasPublicTransport();
    }

    @Override
    public double calculateTime(Route route) {
        return route.getDistance() / speed;
    }

    @Override
    public double calculateCost(Route route) {
        return 1.60; // fixed ticket price
    }
}