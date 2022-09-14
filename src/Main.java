import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Products, makro
        HashMap<String, ArrayList[]> products_with_macro = new HashMap<>();

        //Products
        ArrayList<String> products = new ArrayList<>();
        //Makro
                ArrayList<Integer> wegle = new ArrayList<>();
                ArrayList<Integer> bialko = new ArrayList<>();
                ArrayList<Integer> tluszcz = new ArrayList<>();
                ArrayList<Integer> kcal = new ArrayList<>();
            ArrayList[] makro = {wegle, bialko, tluszcz, kcal};

        //Główny program
        boolean break_while = false;
        while (!break_while) {
            System.out.println("""
                    1 - Display list of products
                    2 - add product
                    3 - delete product
                    4 - quit""");

            //Load choose the option from user
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    DisplayProducts(products);
                    break;
                case 2:
                    AddProducts(products);
                    break;
                case 3:
                    DeleteProducts(products);
                    break;
                case 4:
                    break_while = true;
                default:
                    System.out.println("Lack of option");
                    break;
            } //Switch
        } //While
    } //Function


    static void DisplayProducts(ArrayList<String> products) {
        System.out.println("Lista produktow --> " + products);
    }



    static void AddProducts(ArrayList<String> products) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jaki produkt chcesz dodac?");
        String product_to_add = scan.nextLine();
        products.add(product_to_add);
    }



    static void DeleteProducts(ArrayList<String> products) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Który produkt chcesz usunac?");
        String object = scan.next();
        products.remove(object);
    }
} //class main



