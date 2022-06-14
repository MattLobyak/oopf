package ledza.vehicles;

import java.util.List;

public class CompanyCar extends Vehicle {

    private String ownerCompanyName;

    public String getOwnerCompanyName() {
        return ownerCompanyName;
    }

    public void setOwnerCompanyName(String ownerCompanyName) {
        this.ownerCompanyName = ownerCompanyName;
    }

    public CompanyCar() {
        setType("CompanyCar");
    }

    @Override
    public String toString() {
        return "CompanyCar{" +
                "type='" + getType() + '\'' +
                ", enginePower=" + getEnginePower() +
                ", seatsAmount=" + getSeatsAmount() +
                ", ownerCompanyName='" + ownerCompanyName + '\'' +
                "}\n";
    }

    @Override
    public List<String> getAllFields() {
        List<String> res = super.getAllFields();
        res.add("ownerCompanyName");
        return res;
    }

    @Override
    public void setAllFields(List<String> fieldsValues) {
        super.setAllFields(fieldsValues);
        Integer size = super.getAllFields().size();

        ownerCompanyName = !fieldsValues.get(size).strip().equals("") ? fieldsValues.get(size) : ownerCompanyName;
    }
}
