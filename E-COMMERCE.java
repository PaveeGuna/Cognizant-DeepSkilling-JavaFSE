import java.util.Arrays;
class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Category: " + category;
    }
}

public class Main {
    public static Product linearSearch(Product[] catalog, int targetId) {
        int steps = 0;
        for (Product p : catalog) {
            steps++;
            if (p.productId == targetId) {
                System.out.println("Linear Search found target in " + steps + " steps.");
                return p;
            }
        }
        System.out.println("Linear Search: Product not found.");
        return null;
    }
    public static Product binarySearch(Product[] catalog, int targetId) {
        int left = 0;
        int right = catalog.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;

            if (catalog[mid].productId == targetId) {
                System.out.println("Binary Search found target in " + steps + " steps.");
                return catalog[mid];
            }
            if (catalog[mid].productId < targetId) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        System.out.println("Binary Search: Product not found.");
        return null;
    }

    public static void main(String[] args) {
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(109, "Gaming Monitor", "Displays"),
            new Product(102, "USB-C Cable", "Accessories"),
            new Product(107, "Laptop Stand", "Accessories")
        };

        int searchId = 109; 

        System.out.println("--- Executing Linear Search ---");
        Product foundLinear = linearSearch(inventory, searchId);
        System.out.println("Result: " + foundLinear + "\n");

        System.out.println("--- Executing Binary Search ---");
        Arrays.sort(inventory); 
        Product foundBinary = binarySearch(inventory, searchId);
        System.out.println("Result: " + foundBinary);
    }
}