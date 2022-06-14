package ledza.vehicles;

import java.util.List;

public class Passenger extends Vehicle {

    private boolean isRightDrive;

    public boolean isRightDrive() {
        return isRightDrive;
    }

    public void setRightDrive(boolean rightDrive) {
        isRightDrive = rightDrive;
    }

    public Passenger() {
        setType("Passenger");
    }

    @Override
    public String toString() {
        return "Passenger{" +
                 "type='" + getType() + '\'' +
                ", enginePower=" + getEnginePower() +
                ", seatsAmount=" + getSeatsAmount() +
                ", isRightDrive=" + isRightDrive +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("isRightDrive");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        isRightDrive = !fieldsValues.get(size).strip().equals("") ? Boolean.parseBoolean(fieldsValues.get(size).strip()) : isRightDrive;
    }
}
