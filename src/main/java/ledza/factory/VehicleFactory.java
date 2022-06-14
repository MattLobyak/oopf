package ledza.factory;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    public Map<String, AbstractFactory> factoryMap;

    public VehicleFactory() {
        factoryMap = new HashMap<>();
        factoryMap.put("Passenger", new PassengerFactory());
        factoryMap.put("Bus", new BusFactory());
        factoryMap.put("ElectricCar", new ElectricCarFactory());
        factoryMap.put("Motorbike", new MotorbikeFactory());
        factoryMap.put("CompanyCar", new CompanyCarFactory());
    }
}
