package ledza.vehicles;

import java.util.List;

public class ElectricCar extends Passenger {
    private Integer batteryСapacity;

    public Integer getBatteryСapacity() {
        return batteryСapacity;
    }

    public void setBatteryСapacity(Integer batteryСapacity) {
        this.batteryСapacity = batteryСapacity;
    }

    public ElectricCar() {
        this.setType("ElectricCar");
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "type='" + getType() + '\'' +
                ", EnginePower=" + getEnginePower() +
                ", SeatsAmount=" + getSeatsAmount() +
                ", isRightDrive=" + isRightDrive() +
                ", batteryСapacity=" + batteryСapacity +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("batteryСapacity");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        batteryСapacity = !fieldsValues.get(size).equals("") ? Integer.parseInt(fieldsValues.get(size)) : batteryСapacity;
    }
}