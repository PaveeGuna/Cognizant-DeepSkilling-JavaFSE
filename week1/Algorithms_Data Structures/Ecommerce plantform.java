import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
    }

    static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id)
                return p;
        }
        return null;
    }

    static Product binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Mouse", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(104, "Keyboard", "Electronics"),
                new Product(102, "Phone", "Electronics")
        };

        Product p1 = linearSearch(products, 102);

        if (p1 != null)
            System.out.println("Linear Search: " + p1.productName);

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product p2 = binarySearch(products, 102);

        if (p2 != null)
            System.out.println("Binary Search: " + p2.productName);
    }
}
