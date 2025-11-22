package model;

import strategies.TransportStrategy;

public class Route {
    private City city;
    private double distance;
    private boolean hasPublicTransport;
    private boolean hasBikeLanes;
    private TransportStrategy transportStrategy;

    public Route(City city, double distance, boolean hasPublicTransport, boolean hasBikeLanes) {
        this.city = city;
        this.distance = distance;
        this.hasPublicTransport = hasPublicTransport;
        this.hasBikeLanes = hasBikeLanes;
    }

    public double getDistance() {
        return distance;
    }

    public boolean canTravel() {
        return transportStrategy.canTravel(hasBikeLanes, hasPublicTransport);
    }

    public double calculateTime(Route route) {
        return transportStrategy.calculateTime(route);
    }

    public double calculateCost(Route route) {
        return  transportStrategy.calculateCost(route);
    }
}