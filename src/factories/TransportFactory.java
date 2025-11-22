package factories;

import strategies.TransportStrategy;

public interface TransportFactory {
    public TransportStrategy createPTStrategy(double speed, double distance);
    public TransportStrategy createCarStrategy(double speed, double distance, double gasPerKilometer);
    public TransportStrategy createWalkStrategy(double speed, double distance);
    public TransportStrategy createBikeStrategy(double speed, double distance);
}
