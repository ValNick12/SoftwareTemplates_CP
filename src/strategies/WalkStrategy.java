package strategies;
import model.Exceptions.*;

public class WalkStrategy extends BaseStrategy {

    public WalkStrategy(double speed, double distance) {
        super(speed, distance);
    }

    @Override
    public void execute() {
        System.out.println("--- Walk Info ---\n");
    }

    @Override
    public double calculateTime() {
        if(this.distance <= 40) {
            return this.distance / this.speed;
        } else {
            throw new TooLongToWalkException();
        }
    }

    @Override
    public double calculateCost() {
        return 0.0; // It's free
    }
}
