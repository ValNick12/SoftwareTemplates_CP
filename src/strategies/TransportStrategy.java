package strategies;

public interface TransportStrategy {
    boolean canTravel();
    double calculateTime();// in hours
    double calculateETA();
    double calculateCost();   // fuel or ticket cost
}
