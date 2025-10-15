//class Product{
//    int id;
//    int price;
//    String name;
//    public void printDetails(){
//        System.out.println("My product id is " + id);
//        System.out.println("and my product name is "+ name);
//    }
//
//    public String getProductOfHighPrice() {
//        if (price > 300) {
//            return name;
//        }
//
//    }
//}



//class Product{
//    int id;
//    float cost;
//    String name;
//    public void printDetails(){
//        System.out.println("My product id is " + id);
//        System.out.println("and my product name is "+ name);
//    }
//
//    public String getProd(){
//        return name;
//    }
//}
//
//public class ListEx {
//    public static void main(String[] args) {
//        System.out.println("This is our custom class");
//        Product rice = new Product(); // Instantiating a new Employee Object
//        Product oil = new Product(); // Instantiating a new Employee Object
//
//        // Setting Attributes for Harry
//        rice.id = 12;
//        rice.cost = 34;
//        rice.name = "Basmati Rice";
//
//        // Setting Attributes for John
//        oil.id = 17;
//        oil.cost = 12;
//        oil.name = "Fortune oil";
//
//        // Printing the Attributes
//        rice.printDetails();
//        oil.printDetails();
//
//        // System.out.println(harry.id);
//        // System.out.println(harry.name);
//    }
//}

import java.util.ArrayList;
import java.util.List;
class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class ListEx {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenovo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        List<Float> productPriceList = new ArrayList<Float>();
        for (Product product : productsList) {

            // filtering data of list
            int n = 1;
            if (product.price > 30000) {
                productPriceList.add(product.price);
            }
        }
        System.out.println(productPriceList);
    }
}
