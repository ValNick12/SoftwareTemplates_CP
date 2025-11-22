package factories;

import strategies.*;

public class SungurlareTransportFactory implements TransportFactory {
    private boolean hasPublicTransport = true;
    private double ticketCost = 1.0;
    private boolean hasBikeLines = true;

    // --- private construtor ---
    private SungurlareTransportFactory() {}

    // --- lazy holder singleton ---
    private static class Holder {
        private static final SungurlareTransportFactory INSTANCE = new SungurlareTransportFactory();
    }

    // --- public accessor ---
    public static SungurlareTransportFactory getInstance() {
        return SungurlareTransportFactory.Holder.INSTANCE;
    }

    @Override
    public TransportStrategy createPTStrategy(double speed, double distance) {
        return new PublicTransportStrategy(speed, distance, this.hasPublicTransport, this.ticketCost);
    }

    @Override
    public TransportStrategy createCarStrategy(double speed, double distance, double fuelConsumption) {
        return new CarStrategy(speed, distance, fuelConsumption);
    }

    @Override
    public TransportStrategy createWalkStrategy(double speed, double distance) {
        return new WalkStrategy(speed, distance);
    }

    @Override
    public TransportStrategy createBikeStrategy(double speed, double distance) {
        return new BikeStrategy(speed, distance, this.hasBikeLines);
    }
}
