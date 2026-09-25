import java.util.Scanner;

public class Cosmetics extends Product implements Discountable{

    private String skinType;
    private String expiration;

    public Cosmetics(String id, String name, double price, int stockQuantity, String skinType, String expiration) {
        super(id, name, price, stockQuantity);
        this.skinType = skinType;
        this.expiration = expiration;
    }

    public String getSkinType(){
        return skinType;
    }
    public String getExpiration(){
        return expiration;
    }

    public void setSkinType(String skinType){
        this.skinType = skinType;
    }
    public void setExpiration(String expiration){
        this.expiration = expiration;
    }

    // Abstract method implementations
    @Override
    public String getCategory() {
        return "Cosmetics";
    }

    @Override
    public void printSpecificInfo() {
        System.out.println("Skin Type: " + skinType);
        System.out.println("Expiration Date: " + expiration);
    }

    @Override
    public void updateSpecificFields(Scanner scanner) {

        System.out.printf("Enter new skin type [%s]: ", skinType);
        String newSkinType = scanner.nextLine();
        if (!newSkinType.isEmpty()) {
            skinType = newSkinType;
        }

        System.out.printf("Enter new expiration date [%s]: ",expiration);
        String newExpiration = scanner.nextLine();
        if (!newExpiration.isEmpty()) {
            expiration = newExpiration;
        }
    }

    // Interface method
    @Override
    public double getDiscountedPrice() {

        // 10% discount
        return getPrice() * 0.90;
    }
}
