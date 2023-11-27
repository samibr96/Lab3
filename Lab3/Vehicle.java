import java.awt.*;


public abstract class Vehicle implements Movable {

    private String modelName;
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private Direction direction ;
    private double x;
    private double y;
    private boolean engineTurnOn = false;


    public Vehicle (String modelName, int nrDoors, double enginePower, double currentSpeed, Color color, Direction direction , double x, double y) {


        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }




    public void startEngine() {


        if (!isEngineTurnOn()) {
            engineTurnOn = true;
            currentSpeed = 0.1;
        }
    }

    public void stopEngine() {
        currentSpeed = 0;
        engineTurnOn = false;
    }


    protected abstract double speedFactor();



    private void incrementSpeed(double amount)
    {
        if (engineTurnOn) {
            currentSpeed = (getCurrentSpeed() + speedFactor()) * (amount);
            if (currentSpeed > enginePower)

            {
                currentSpeed = enginePower;
            }
        }
    }

    private void decrementSpeed(double amount)
    {
        currentSpeed = (getCurrentSpeed() - speedFactor()) * (amount);
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }



    public void setX(double x)

    {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }



    public void setEngineTurnOn(boolean engineTurnOn) {
        this.engineTurnOn = engineTurnOn;
    }

    public void setDirection(Direction direction ) {
        this.direction  = direction ;
    }

    public Direction getDirection () {
        return direction;
    }


    public boolean Move_dir() {
        return currentSpeed != 0;
    }

    public boolean isEngineTurnOn() {
        return engineTurnOn;
    }


    public void move() {
        if (direction  == Direction.NORTH) {
            setY(getY() - getCurrentSpeed());}
        else if (direction  == Direction.EAST) {
            setX(getX() + getCurrentSpeed());}
        else if (direction  == Direction.WEST) {
            setX(getX() - getCurrentSpeed());}
        else if (direction  == Direction.SOUTH) {
            setY(getY() + getCurrentSpeed());}
    }



    public void turnLeft(){
        if (direction  == Direction.NORTH) {
            direction  = Direction.WEST;}
        else if (direction  == Direction.EAST) {
            direction  = Direction.NORTH;}
        else if (direction  == Direction.WEST) {
            direction  = Direction.SOUTH;}
        else if (direction  == Direction.SOUTH) {
            direction  = Direction.EAST;}

    }


    public void turnRight() {
        if (direction  == Direction.NORTH) {
            direction  = Direction.EAST;}
        else if (direction  == Direction.EAST) {
            direction  = Direction.SOUTH;}
        else if (direction  == Direction.WEST) {
            direction  = Direction.NORTH;}
        else if (direction  == Direction.SOUTH) {
            direction  = Direction.WEST;}
    }



    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }



    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }


    public void reverseDirection()
    {
        this.turnLeft();
        this.turnLeft();
    }


}