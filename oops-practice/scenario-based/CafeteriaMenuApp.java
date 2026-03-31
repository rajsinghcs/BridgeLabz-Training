import java.util.*;
public class CafeteriaMenuApp {

    // Method to display menu items with index
    public static void displayMenu(String[] menuItem){
        System.out.println("Cafeteria Menu");
        for(int i=0;i<menuItem.length;i++){
            System.out.println(i + " : "+menuItem[i]);
        }

    }
     // Method to get item by index
     public static String getItemByIndex(int index, String[] menuItem){
        if(index < 0 || index >= menuItem.length){
            return "Invalid Menu Item";
        }
        return menuItem[index];
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed menu items
        String [] menuItem = {"Veg Sandwich",
            "Cheese Burger",
            "Paneer Roll",
            "Masala Dosa",
            "Fried Rice",
            "Pasta",
            "Samosa",
            "Coffee",
            "Tea",
            "Cold Drink"
        };
        // Display menu 
        System.out.println("Welcome to the Cafeteria!");
        displayMenu(menuItem);

         // Take customer choice
        System.out.print("Please enter the index of the menu item you want to order: ");
        int index = sc.nextInt();

        String selectedItem = getItemByIndex(index, menuItem);
        System.out.println("You ordered: " + selectedItem);
        
    }
    
}
