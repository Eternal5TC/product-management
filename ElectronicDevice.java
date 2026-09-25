import java.util.Scanner;

public class ElectronicDevice extends Product {

    private int storage;
    private int warranty;

    public ElectronicDevice(String id,String name,double price,int stockQuantity,int storage,int warranty) {
        super(id, name, price, stockQuantity);
        this.storage = storage;
        this.warranty = warranty;
    }

    public int getStorage() {
        return storage;
    }
    public int getWarranty() {
        return warranty;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    // Abstract method implementations

    @Override
    public String getCategory() {
        return "Electronic Device";
    }

    @Override
    public void printSpecificInfo() {
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Warranty: " + warranty + " months");
    }

    @Override
    public void updateSpecificFields(Scanner scanner) {

        System.out.printf("Enter new storage [%d]: ", storage);
        String storageInput = scanner.nextLine();
        if (!storageInput.isEmpty()) {
            storage = Integer.parseInt(storageInput);
        }

        System.out.printf("Enter new warranty [%d]: ", warranty);
        String warrantyInput = scanner.nextLine();
        if (!warrantyInput.isEmpty()) {
            warranty = Integer.parseInt(warrantyInput);
        }
    }
}