package strategies;

public interface TransportStrategy {
    void execute();
    double calculateTime();// in hours
    double calculateCost();   // fuel or ticket cost
}
