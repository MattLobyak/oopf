package ledza.vehicles;

import java.util.List;

public class Motorbike extends Vehicle {

    private String bikeNumber;

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public Motorbike() {
        setType("Motorbike");
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "type='" + getType() + '\'' +
                ", EnginePower=" + getEnginePower() +
                ", SeatsAmount=" + getSeatsAmount() +
                ", bikeNumber='" + bikeNumber + '\'' +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res =  super.getAllFields();
        res.add("bikeNumber");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        try {
            bikeNumber = !fieldsValues.get(size).equals("") ? fieldsValues.get(size) : bikeNumber;
        }
        catch (Exception e){
            System.out.println("Error value");
        }
    }
}
