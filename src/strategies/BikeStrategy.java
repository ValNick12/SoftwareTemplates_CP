package strategies;
import model.Exceptions.*;

public class BikeStrategy extends BaseStrategy {
    private boolean hasBikeLines;

    public BikeStrategy(double speed, double distance, boolean hasBikeLines) {
        super(speed, distance);
        this.hasBikeLines = hasBikeLines;
    }

    @Override
    public void execute() {
        System.out.println("Bike is traveling...");
    }

    @Override
    public double calculateTime() {
        if(this.hasBikeLines) {
            return this.distance / this.speed;
        } else {
            throw new NoBikeLanesException();
        }
    }

    @Override
    public double calculateCost() {
        return 0.0;
    }
}
