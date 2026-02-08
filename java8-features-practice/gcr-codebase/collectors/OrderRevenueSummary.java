package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Amit", 1200),
                new Order("Rohit", 800),
                new Order("Amit", 500)
        );

        Map<String, Double> revenue =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println(revenue);
    }
}

class Order {
    private String customer;
    private double amount;

    public Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() { return customer; }
    public double getAmount() { return amount; }
}

