package strategies;

import model.Route;

public class CarStrategy implements TransportStrategy {

    private double speed;

    public CarStrategy(double speed) {
        this.speed = speed;
    }

    @Override
    public boolean canTravel(boolean hasBikeLanes, boolean hasPublicTransport) {
        return true; // car can always travel
    }

    @Override
    public double calculateTime(Route route) {
        return route.getDistance() / speed;
    }

    @Override
    public double calculateCost(Route route) {
        double fuelPricePerKm = 0.20;
        return route.getDistance() * fuelPricePerKm;
    }
}
