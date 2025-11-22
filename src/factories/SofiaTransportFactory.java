package factories;
import strategies.*;
import model.City;

public class SofiaTransportFactory implements ITransportFactory {
    private boolean hasPublicTransport = true;
    private double ticketCostForPublicTransport = 1.6;
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
    public TransportStrategy createWalkStrategy(double speed, double distance) {

    }
}
