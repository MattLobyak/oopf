package ledza;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ledza.vehicles.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JsonSerializer {

    public Map<String, Class> typesToTypeMap;
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serialize(Vehicle obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public Object deserialize(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Object.class);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void saveInJsonFile(List<Vehicle> devices) throws IOException {
        String json = objectMapper.writeValueAsString(devices);
        FileOutputStream file = new FileOutputStream("vehicles.json");
        file.write(json.getBytes(StandardCharsets.UTF_8));
        file.close();
    }

    public List<Vehicle> loadFromJsonFile() throws IOException{

        FileInputStream file = new FileInputStream("vehicles.json");
        byte[] jsonBytes = file.readAllBytes();

        ArrayNode jsonNodes = (ArrayNode) objectMapper.readTree(jsonBytes);
        Iterator<JsonNode> iterator = jsonNodes.iterator();

        List<Vehicle> devices = new ArrayList<>();

        while (iterator.hasNext()){
            JsonNode jsonNode = iterator.next();
            String type = jsonNode.get("type").asText();
            Vehicle device = (Vehicle) objectMapper.convertValue(jsonNode, typesToTypeMap.get(type));

            devices.add(device);
        }
        return devices;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonSerializer() {
        typesToTypeMap = new HashMap<>();
        typesToTypeMap.put("Passenger", Passenger.class);
        typesToTypeMap.put("Bus", Bus.class);
        typesToTypeMap.put("ElectricCar", ElectricCar.class);
        typesToTypeMap.put("Motorbike", Motorbike.class);
        typesToTypeMap.put("CompanyCar", CompanyCar.class);
    }
}
