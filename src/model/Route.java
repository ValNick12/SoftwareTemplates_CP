package model;

import strategies.TransportStrategy;

public class Route {
    private TransportStrategy strategy;

    public Route() {}

    public Route(TransportStrategy strategy) {
        this.strategy = strategy;
    }

    public TransportStrategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(TransportStrategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        this.strategy.execute();
    }

    public double calculateTime() {
        return this.strategy.calculateTime();
    }

    public double calculateCost() {
        return this.strategy.calculateCost();
    }
}