package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String text = "java stream api makes java code clean";

        Map<String, Integer> frequency =
                Arrays.stream(text.split(" "))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1,
                                Integer::sum
                        ));

        System.out.println(frequency);
    }
}

