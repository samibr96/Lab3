import java.util.ArrayList;
import java.util.List;

public class CarRepairShop <T extends Vehicle> {

    private ArrayList<T> cars;

    public double x;
    public double y;
    private int maxNrOfCas;

    public CarRepairShop(int maxAmountOfCars, double x, double y) {

        cars = new ArrayList<>();
        this.maxNrOfCas = maxAmountOfCars;
        this.x = x;
        this.y = y;
    }



    public boolean isWorkShopFull() {
        return cars.size() >= maxNrOfCas;
    }

    public void carload (T car)
    {
        if(cars.size() < maxNrOfCas){
            cars.add(car);
        }
    }

    public void carUnload (T car)
    {
        cars.remove(car);
    }

    public List<T> getCars() {
        return cars;
    }
}
