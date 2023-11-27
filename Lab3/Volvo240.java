import java.awt.*;

public class Volvo240 extends Vehicle {

    private Trim trim;

    public Volvo240(Direction direction, double x, double y) {
        super("Volvo240", 4, 4, 2, Color.BLUE, direction, x, y);

        trim = new Trim(1.25);
    }

    public void setTrimFactor(double trimFactor) {
        trim = new Trim(trimFactor);
    }

    public double getTrimFactor() {
        return trim.getTrimFactor();

    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * getTrimFactor();

    }
}
