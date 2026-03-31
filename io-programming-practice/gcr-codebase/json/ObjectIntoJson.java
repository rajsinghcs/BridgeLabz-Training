package json;

import com.fasterxml.jackson.databind.ObjectMapper;
class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class ObjectIntoJson {
    public static void main(String[] args) throws Exception {

        Car car = new Car("Tesla", "Model S", 2024);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(car);

        System.out.println(json);
    }
}

