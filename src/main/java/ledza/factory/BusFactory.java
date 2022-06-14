package ledza.factory;

import ledza.vehicles.Bus;
import ledza.vehicles.Vehicle;

public class BusFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Bus();
    }
}
