package ledza.factory;

import ledza.vehicles.Passenger;
import ledza.vehicles.Vehicle;

public class PassengerFactory implements AbstractFactory {

    @Override
    public Vehicle createObj() {
        return new Passenger();
    }
}
