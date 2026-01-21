import java.util.*;

abstract class Category{
    abstract String getCategoryName();
}

class BookCategory extends Category{
    public String getCategoryName(){
        return "Books";
    }
}

class ClothingCategory extends Category{
    public String getCategoryName(){
        return "Clothing";
    }
}

class GadgetCategory extends Category{
    public String getCategoryName(){
        return "Gadgets";
    }
}

class Product <T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void display(){
        System.out.println("Product: " + name +"  Category: " + category.getCategoryName() +"  Price: " + price);
    }
}

class Discount{
    public static <T extends Product< ?>> void applyDiscount(T product, double percentage){
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}

class ProductCatalog{
    private List<Product<? extends Category>> catalog = new ArrayList<>();
    public void addProduct(Product<? extends Category> product){
        catalog.add(product);
    }

    public void displayAll(){
        for(Product<? extends Category> product : catalog){
            product.display();
        }
    }
}
public class DynamicOnlineMarketplace {
    public static void main(String[] main){

        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Tshirt", 700, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("IPhone",55000, new GadgetCategory());

        Discount.applyDiscount(book, 10);
        Discount.applyDiscount(shirt, 26);
        Discount.applyDiscount(phone, 18);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        
        catalog.displayAll();

    }
}
