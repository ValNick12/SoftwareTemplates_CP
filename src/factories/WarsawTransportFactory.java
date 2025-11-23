package factories;

import model.Exceptions.NoBikeLanesException;
import model.Exceptions.NoPublicTransportException;
import model.Exceptions.TooLongToWalkException;
import strategies.*;

public class WarsawTransportFactory implements TransportFactory{
    private boolean hasPublicTransport = true;
    private double ticketCost = 3.0;
    private boolean hasBikeLines = true;

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
