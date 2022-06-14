package ledza.factory;

import ledza.vehicles.Vehicle;
import ledza.vehicles.Motorbike;

public class MotorbikeFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Motorbike();
    }
}
