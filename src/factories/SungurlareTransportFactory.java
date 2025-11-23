package factories;

import model.Exceptions.NoBikeLanesException;
import model.Exceptions.NoPublicTransportException;
import model.Exceptions.TooLongToWalkException;
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
        try {
            return new PublicTransportStrategy(speed, distance, this.hasPublicTransport, this.ticketCost);
        }catch (NoPublicTransportException e) {
            throw new NoPublicTransportException();
        }
    }
    @Override
    public TransportStrategy createCarStrategy(double speed, double distance, double fuelConsumption) {
        return new CarStrategy(speed, distance, fuelConsumption);
    }

    @Override
    public TransportStrategy createWalkStrategy(double speed, double distance) {
        try {
            return new WalkStrategy(speed, distance);
        }catch (TooLongToWalkException e) {
            throw new TooLongToWalkException();
        }
    }

    @Override
    public TransportStrategy createBikeStrategy(double speed, double distance) {
        try {
            return new BikeStrategy(speed, distance, this.hasBikeLines);
        }catch (NoBikeLanesException e) {
            throw new NoBikeLanesException();
        }
    }
}
