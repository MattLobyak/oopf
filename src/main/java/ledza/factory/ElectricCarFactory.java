package ledza.factory;

import ledza.vehicles.Vehicle;
import ledza.vehicles.ElectricCar;

public class ElectricCarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new ElectricCar();
    }
}
