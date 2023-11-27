import java.awt.*;

public abstract class Truck extends Vehicle {

    public boolean platform;

    public Truck(String modelName, int nrDoors, double enginePower, double currentSpeed, Color color, Direction direction , double x, double y) {
        super(modelName, nrDoors, enginePower, currentSpeed, color, direction , x, y);
        this.platform = false;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            platform = true;
        }
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            platform = false;
        }
    }

    public void move() {
        if (!platform) {
            super.move();
        }
    }
}
