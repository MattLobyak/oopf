package ledza.vehicles;

public class Bus extends Vehicle {

    public Bus() {
        setType("Bus");
    }

    @Override
    public String toString() {
        return "Bus{" +
                "type='" + getType() + '\'' +
                ", EnginePower=" + getEnginePower() +
                ", SeatsAmount=" + getSeatsAmount() +
                "}\n";
    }
}
