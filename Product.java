import java.util.Scanner;

public abstract class Product {

    private String id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Abstract methods
    public abstract String getCategory();
    public abstract void printSpecificInfo();
    public abstract void updateSpecificFields(Scanner scanner);

    // Common information
    public void printInfo() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println("Stock Quantity: " + stockQuantity);
        System.out.println("Category: " + getCategory());

        printSpecificInfo();
    }

    public void discountProduct(){
        
    }

}