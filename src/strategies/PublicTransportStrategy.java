package strategies;

import model.Exceptions.NoPublicTransportException;

public class PublicTransportStrategy extends BaseStrategy {

    private double ticketCost;
    private boolean hasPublicTransport;

    public PublicTransportStrategy(double speed, double distance, boolean hasPublicTransport, double ticketCost) {
        super(speed, distance);
        this.hasPublicTransport = hasPublicTransport;
        this.ticketCost = ticketCost;
    }

    @Override
    public void execute() {
        System.out.println("--- Public Transport Info ---\n");
    }

    @Override
    public double calculateTime() {
        if(this.hasPublicTransport) {
            return this.distance / this.speed;
        } else {
            throw new NoPublicTransportException();
        }
    }

    @Override
    public double calculateCost() {
        return calculateTime() * this.ticketCost; // every hour traveler pays ticket
    }
}