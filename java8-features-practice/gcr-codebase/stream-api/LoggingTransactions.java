package streamapi;

import java.time.LocalDateTime;
import java.util.List;

public class LoggingTransactions {
    public static void main(String[] args) {

        List<Integer> IDs = List.of(
                101002,
                102023,
                100023,
                103023
        );

        IDs.forEach(id -> System.out.println(LocalDateTime.now() + " Transaction: " + id));
    }
}
