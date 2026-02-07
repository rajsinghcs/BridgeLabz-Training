package streamapi;

import java.util.List;

public class StockPrice {
    public static void main(String[] args) {

        List<Double> stockPrices = List.of(
                101.5,
                102.75,
                100.9,
                103.2
        );

        stockPrices.forEach(price ->
                System.out.println("Stock Price Update " + price)
        );
    }
}

