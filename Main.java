import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();

    static int electronicCount = 0;
    static int clothesCount = 0;
    static int cosmeticsCount = 0;


    static void addProduct() {
        int categoryInput;

        System.out.println();
        System.out.println("ADD PRODUCT: ");
        System.out.println("1. Electronic Device");
        System.out.println("2. Clothes");
        System.out.println("3. Cosmetics");
        System.out.println();

        System.out.print("Choose category (1-3): ");
        categoryInput = input.nextInt();

        if (categoryInput < 1 || categoryInput > 3) {
            System.out.println();
            System.out.println("Invalid category!");
            return;
        }

        input.nextLine(); // fix clear enter

        System.out.print("Enter product name: ");
        String name = input.nextLine();
        System.out.print("Enter price: ");
        double price = input.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stockQuantity = input.nextInt();

        input.nextLine();   //fix clear enter

        if (categoryInput == 1) {

            electronicCount++;

            String id = String.format("E%03d",electronicCount);

            System.out.print("Enter storage (GB): ");
            int storage = input.nextInt();
            System.out.print("Enter warranty (months): ");
            int warranty = input.nextInt();


            ElectronicDevice electronic = new ElectronicDevice(id, name, price, stockQuantity, storage, warranty);

            products.add(electronic);

            System.out.println();
            System.out.println("Product " + electronic.getName() +" added successfully!");
            System.out.println("Product ID: " + id);
        }
        else if (categoryInput ==2){
            clothesCount++;

            String id = String.format("C%03d",clothesCount);

            System.out.print("Enter size (S, M, L, XL, XXL): ");
            String size = input.nextLine();
            System.out.print("Enter color: ");
            String color = input.nextLine();


            Clothes clothes = new Clothes(id, name, price, stockQuantity, size, color);

            products.add(clothes);

            System.out.println("");
            System.out.println("Product " + clothes.getName() +" added successfully!");
            System.out.println("Product ID: " + id);

        }
        else if( categoryInput == 3 ){
            cosmeticsCount++;

            String id = String.format("CS%03d",cosmeticsCount);

            System.out.print("Enter skin type:");
            String skinType = input.nextLine();
            System.out.print("Enter expiration date (DD/MM/YYYY): ");
            String expiration = input.nextLine();


            Cosmetics cosmetics = new Cosmetics(id, name, price, stockQuantity, skinType, expiration);

            products.add(cosmetics);

            System.out.println();
            System.out.println("Product " + cosmetics.getName() +" added successfully!");
            System.out.println("Product ID: " + id);
        }
    }

    static void viewProducts() {

        System.out.println();
        System.out.println("================= VIEW PRODUCTS ================");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        int number = 1;

        for (Product p : products) {

            System.out.println();
            System.out.println("Product #" + number);

            p.printInfo();

            number++;
        }
        System.out.println();
    }

    static void updateProduct(){

        System.out.println();
        System.out.println("UPDATE PRODUCTS:");

        input.nextLine();

        System.out.print("Enter product ID to update: ");
        String id = input.next();

        Product found = findProductById(id);  // find product to update

        if (found == null){
            System.out.println("Product not found");
            return;
        }

        System.out.println();
        System.out.println("Product Found: " + found.getName());

        input.nextLine();

        System.out.printf("Enter new name [%s]: ", found.getName());
        String name = input.nextLine();
        if (!name.isEmpty()){
            found.setName(name);
        }
        System.out.printf("Enter new Price [%s]: ", found.getPrice());
        String priceInput = input.nextLine();
        if (!priceInput.isEmpty()){
            double price = Double.parseDouble(priceInput);

            found.setPrice(price);
        }
        System.out.printf("Enter new stock quentity [%s]: ", found.getStockQuantity());
        String stockQuantityInput = input.nextLine();
        if (!stockQuantityInput.isEmpty()){
            Integer stockQuantity = Integer.parseInt(stockQuantityInput);

            found.setStockQuantity(stockQuantity);
        }

        found.updateSpecificFields(input);

        System.out.println();
        System.out.println("Product updated successfully");

    }

    static void deleteProduct(){

        System.out.println();
        System.out.println("DELETE PRODUCT:");

        input.nextLine();   // fix enter error

        System.out.print("Enter product ID to delete: ");
        String id = input.nextLine();

        Product product = findProductById(id);

        if (product == null){
            System.out.println("Product not found");
            return;
        }

        products.remove(product);

        System.out.println();
        System.out.printf("Product ID: %s, Name: %s deleted successfully.%n", product.getId(), product.getName());
    }

    static void discountProduct(){
        System.out.println();
        System.out.println("DISCOUNT PRODUCT:");

        boolean foundDiscount = false;

        for(Product p : products){
            if ( p instanceof Discountable){
                Discountable d = (Discountable) p ;
                System.out.printf("%s (%s): $%.2f -> $%.2f%n", p.getName(), p.getId(), p.getPrice(), d.getDiscountedPrice());
            }
            foundDiscount = true;
        }

        if (!foundDiscount){
            System.out.println("NO discount produt avilable");
        }
    }

    static Product findProductById(String id){

        for (Product p :  products){
            if ( p.getId().equalsIgnoreCase(id) ){
                return p;
            }
        }
        return null;
    }

    static void menu(){

        int choice;

        do {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("       E-COMMERCE PRODUCT MANAGEMENT");
            System.out.println("==============================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Discoount Product");
            System.out.println("6. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    discountProduct();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice!");
                    System.out.println("Please choose between 1 and 5.");
                    break;
            }
        } while (choice != 6);
        input.close();
    }

    public static void main(String[] args) {
        menu();
    }
}