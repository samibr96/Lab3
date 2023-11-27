import java.awt.*;

public class Scania extends Truck {
    double platform = 0;


    public Scania(Direction direction, double x, double y) {
        super("Scania", 2, 4, 0, Color.RED, direction , x, y);
    }

    public double getPlatformAngle() {
        return platform;
    }

    public void raisePlatform(double degrees) {

        if (getCurrentSpeed() == 0) {
            platform = Math.min(platform + degrees, 70);
        }
    }

    public void lowerPlatform(double degrees) {

        if (getCurrentSpeed() == 0) {
            platform = Math.max(platform - degrees, 0);
        }
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


    @Override
    public void move() {
        if (getPlatformAngle() == 0) {
            super.move();
        }
    }
}
