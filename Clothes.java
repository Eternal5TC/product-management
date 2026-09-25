import java.util.Scanner;

public class Clothes extends Product implements Discountable {

    private String size;
    private String color;

    public Clothes(String id, String name, double price, int stockQuantity, String size, String color) {
        super (id, name, price, stockQuantity);
        this.size = size;
        this.color = color;
    }

    public String getSize(){
        return size;
    }
    public String getColor(){
        return color;
    }

    public void setSize(String size){
        this.size = size;
    }
    public void setColor(String color){
        this.color = color;
    }

    // Abstract method implementations
    @Override
    public String getCategory() {
        return "Clothes";
    }

    @Override
    public void printSpecificInfo() {
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
    }

    @Override
    public void updateSpecificFields(Scanner scanner) {

        System.out.printf("Enter new size [%s]: ", size);
        String newSize = scanner.nextLine();
        if (!newSize.isEmpty()) {
            size = newSize;
        }

        System.out.printf("Enter new color [%s]: ", color);
        String newColor = scanner.nextLine();
        if (!newColor.isEmpty()) {
            color = newColor;
        }
    }

    // Interface method

    @Override
    public double getDiscountedPrice() {
        // 20% discount
        return getPrice() * 0.80;
    }
}
