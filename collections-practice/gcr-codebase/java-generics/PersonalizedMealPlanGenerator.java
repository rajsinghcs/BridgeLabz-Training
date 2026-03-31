import java.util.*;
interface MealPlan {
    String getMealType();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public boolean isValid() {
        return true;
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public boolean isValid() {
        return true;
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public boolean isValid() {
        return true;
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein";
    }

    public boolean isValid() {
        return true;
    }
}

class Meal<T extends MealPlan> {

    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public void display() {
        System.out.println("Meal Plan Generated: " + plan.getMealType());
    }

    public T getPlan() {
        return plan;
    }
}

class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {

        if (!plan.isValid()) {
            throw new IllegalArgumentException("Invalid meal plan");
        }

        return new Meal<>(plan);
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = MealGenerator.generateMeal(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealGenerator.generateMeal(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealGenerator.generateMeal(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal = MealGenerator.generateMeal(new HighProteinMeal());
        
        vegMeal.display();
        veganMeal.display();
        ketoMeal.display();
        proteinMeal.display();
    }
}

