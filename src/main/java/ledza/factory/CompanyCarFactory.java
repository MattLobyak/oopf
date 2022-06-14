package ledza.factory;

import ledza.vehicles.Vehicle;
import ledza.vehicles.CompanyCar;

public class CompanyCarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new CompanyCar();
    }
}
