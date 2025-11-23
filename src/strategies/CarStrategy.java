package strategies;

public class CarStrategy extends BaseStrategy {

    private double fuelConsumption;
    private double fuelCost;

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
        return this.distance * (this.fuelConsumption / 100) * this.fuelCost;
    }
}
