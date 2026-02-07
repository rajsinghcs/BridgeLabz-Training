package streamapi;

import java.util.List;

public class IoTSensor {
    public static void main(String[] args) {

        List<Double> readings = List.of(
                22.5,
                35.8,
                18.2,
                42.1,
                29.9
        );

        readings.stream()
                .filter(r -> r > 30)
                .forEach(r ->
                        System.out.println("Sensor reading more than threshold " + r)
                );
    }
}

