package factories;
import model.Exceptions.*;
import strategies.*;

public class SofiaTransportFactory implements TransportFactory {
    private boolean hasPublicTransport = true;
    private double ticketCost = 1.6;
    private boolean hasBikeLines = false;

    // --- private construtor ---
    private SofiaTransportFactory() {}

    // --- lazy holder singleton ---
    private static class Holder {
        private static final SofiaTransportFactory INSTANCE = new SofiaTransportFactory();
    }

    // --- public accessor ---
    public static SofiaTransportFactory getInstance() {
        return Holder.INSTANCE;
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
            return new BikeStrategy(speed, distance);
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
