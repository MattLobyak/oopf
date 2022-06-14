package ledza;

import ledza.vehicles.*;
import ledza.factory.AbstractFactory;
import ledza.factory.VehicleFactory;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void getHelp(){
        System.out.println("Enter number:");
        System.out.println("1) Load from file");
        System.out.println("2) Save in file");
        System.out.println("3) Print List");
        System.out.println("4) Delete element from List");
        System.out.println("5) Add element to List");
        System.out.println("6) Edit element");
        System.out.println("7) Help");
        System.out.println("8) Exit");
    }

    public static void deleteElement(List<Vehicle> devices){
        for (int i =0;i<devices.size();i++){
            System.out.print(i+1 + ") ");
            System.out.print(devices.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose element number:");
        Integer num = Integer.parseInt(scanner.next());

        if (num > devices.size() || num < 1){
            System.out.println("Error number");
            return;
        }
        devices.remove(num-1);
        System.out.println("Successful deletion");
    }

    public static void addElement(List<Vehicle> devices){

        JsonSerializer jsonSerializer = new JsonSerializer();
        List<String> types = new ArrayList<>(jsonSerializer.typesToTypeMap.keySet());

        for (int i = 0; i<types.size();i++){
            System.out.println(i+1 + ") " + types.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        String choosedType;
        try{
            Integer num =  Integer.parseInt(scanner.next());
            choosedType = types.get(num-1);
        }
        catch (Exception e){
            System.out.println("Error number");
            return;
        }
        VehicleFactory deviceFactory = new VehicleFactory();
        AbstractFactory factory = deviceFactory.factoryMap.get(choosedType);
        Vehicle device = factory.createObj();
        devices.add(device);
    }

    public static void editElement(List<Vehicle> devices){
        for (int i = 0; i<devices.size();i++){
            System.out.println(i+1 + ") " + devices.get(i));
        }

        System.out.print("Choose device: ");
        Scanner scanner = new Scanner(System.in);

        Vehicle device;
        try {
            Integer num = Integer.parseInt(scanner.nextLine().strip());
            device = devices.get(num-1);
        }
        catch (Error error){
            System.out.println("Error num");
            return;
        }

        List<String> values = new ArrayList<>();

        System.out.println(device.getAllFields());
        for (String field : device.getAllFields()){
            System.out.print(field + ": ");
            String temp = scanner.nextLine();
            values.add(temp);
        }
        device.setAllFields(values);
    }

    public static void main(String[] args) throws IOException {

        /*Computer computer = new Computer();
        computer.setThereGPU(true);
        computer.setStorage(100);
        computer.setRAM(20000);

        Notebook notebook = new Notebook();
        notebook.setStorage(5000);
        notebook.setBatteryPower(228);
        notebook.setRAM(50000);

        Watch watch = new Watch();
        watch.setOwner("Rolex");
        watch.setRAM(1000);
        watch.setStorage(20);

        Phone phone = new Phone();
        phone.setPhoneNumber("228-322-22");
        phone.setRAM(500);
        phone.setStorage(1111);

        List<Device> devices = List.of(computer, notebook, watch, phone);
*/
        JsonSerializer jsonSerializer = new JsonSerializer();
        List<Vehicle> devices = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------||||----------------------");
        Main.getHelp();
        while (true){
            System.out.print("Enter number of action you need: ");
            Integer number = Integer.parseInt(scanner.next());

            if (number == 1)
                devices = jsonSerializer.loadFromJsonFile();
            else if (number == 2)
                jsonSerializer.saveInJsonFile(devices);
            else if (number == 3)
                System.out.println(devices);
            else if (number == 4)
                deleteElement(devices);
            else if (number ==5)
                addElement(devices);
            else if (number == 6)
                editElement(devices);
            else if (number == 7)
                getHelp();
            else if (number == 8)
                break;
        }
    }
}
