package strategies;

import model.Route;

public interface TransportStrategy {
    boolean canTravel(boolean hasBikeLanes, boolean hasPublicTransport);
    double calculateTime(double speed, double distance);   // in hours
    double calculateCost(Route route);   // fuel or ticket cost
}
