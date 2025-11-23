package factories;

import strategies.*;

public class WarsawTransportFactory implements TransportFactory{
    private boolean hasPublicTransport = true;
    private double ticketCost = 1.6;
    private boolean hasBikeLines = false;

    // --- private construtor ---
    private WarsawTransportFactory() {}

    // --- lazy holder singleton ---
    private static class Holder {
        private static final WarsawTransportFactory INSTANCE = new WarsawTransportFactory();
    }

    // --- public accessor ---
    public static WarsawTransportFactory getInstance() {
        return WarsawTransportFactory.Holder.INSTANCE;
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
