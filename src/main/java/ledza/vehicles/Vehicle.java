package ledza.vehicles;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    private String type;
    private Integer enginePower;
    private Integer seatsAmount;


    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(Integer seatsAmount) {
        this.seatsAmount = seatsAmount;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", Engine power=" + enginePower +
                ", Seats amount=" + seatsAmount;
    }

    public void change(){
        System.out.println("CHANGING!!!");
    }

    @JsonIgnore
    public List<String> getAllFields(){
        List<String> res = new ArrayList<>();
        res.add("enginePower");
        res.add("seatsAmount");
        return res;
    }

    public void setAllFields(List<String> fieldsValues){
        try{
            enginePower = !fieldsValues.get(0).strip().equals("") ? Integer.parseInt(fieldsValues.get(0).strip()) : enginePower;
            seatsAmount = !fieldsValues.get(1).strip().equals("") ? Integer.parseInt(fieldsValues.get(1).strip()) : seatsAmount;
        }
        catch (Exception e){
            System.out.println("Error value");

        }
    }
}

