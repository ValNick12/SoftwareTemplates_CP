package strategies;

public abstract class BaseStrategy implements TransportStrategy {
    protected double speed;
    protected double distance;

    public BaseStrategy(double speed, double distance) {
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public abstract void execute();

    @Override
    public abstract double calculateTime();

    @Override
    public abstract double calculateCost();
}
