import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    ArrayList<Vehicle> cars = new ArrayList<>();

    public static Volvo240 volvo = new Volvo240(Direction.EAST, 0, 0);

    public static Saab95 saab = new Saab95(Direction.EAST, 0, 100);
    public static Scania scania = new Scania(Direction.EAST, 0, 200);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(saab);
        cc.cars.add(volvo);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) { // for (ACar car : cars)

                    car.move();
                    frame.drawPanel.repaint();
                }
            }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars //        for (ACar car : cars

        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).raisePlatform(45);
            }
        }
    }

    void lowerBed() {
        for (Vehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                ((Scania) car).lowerPlatform(45);
            }
        }
    }
}