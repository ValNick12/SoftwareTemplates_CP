package strategies;

public class CarStrategy extends BaseStrategy {

    private final double fuelConsumption;
    private final double fuelCost = 2.93;

    public CarStrategy(double speed, double distance, double fuelConsumption) {
        super(speed, distance);
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void execute() {
        System.out.println("--- Car Info ---\n");
    }

    @Override
    public double calculateTime() {
        return this.distance / this.speed;
    }

    @Override
    public double calculateCost() {
        return this.distance * (this.fuelConsumption / 100) * fuelCost;
    }
}
