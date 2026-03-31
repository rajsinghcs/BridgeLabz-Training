import java.util.*;
abstract class WareHouseItem{
    String name;
    int units;
    int price;

    WareHouseItem(String name,int units,int price){
        this.name = name;
        this.units = units;
        this.price = price;
    }

    abstract public void category();
    public void display(){
        System.out.println("Item name- "+ name+" "+"No. of Items- "+units+" "+"Item price- "+ price);
    }

}

class Electronics extends WareHouseItem{

    Electronics(String name,int units,int price){
        super(name, units, price);
    }
    public void category(){
        System.out.println("Electronics");
    }

}

class Groceries extends WareHouseItem{
    Groceries(String name,int units,int price){
        super(name, units, price);
    }
    public void category(){
        System.out.println("Groceries");
    }

}

class Furniture extends WareHouseItem{
    Furniture(String name,int units,int price){
        super(name, units, price);
    }
    public void category(){
        System.out.println("Furniture");
    }

}

class Storage<T extends WareHouseItem>{
    ArrayList<T> store = new ArrayList();
    void addItems(T item){
        store.add(item);
    }

    List<T> getItems(){
        return store;
    }

}

class WildcardDisplay{
    public static void displayAll(List<? extends WareHouseItem> items) {
        for (WareHouseItem item : items) {
            item.display();
            item.category();
            System.out.println(" ");
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args){
        
        Storage<Furniture> storage1 = new Storage<>();
        Storage<Groceries> storage2 = new Storage<>();
        Storage<Electronics> storage3 = new Storage<>();

        storage1.addItems(new Furniture("Table",15,2500));
        storage2.addItems(new Groceries("Sugar",100,45));
        storage3.addItems(new Electronics("Fan",45,3300));

        System.out.println("Electronics Storage:");
        WildcardDisplay.displayAll(storage1.getItems());

        System.out.println("Groceries Storage:");
        WildcardDisplay.displayAll(storage2.getItems());

        System.out.println("Furniture Storage:");
        WildcardDisplay.displayAll(storage3.getItems());

    }

}
