import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();
        ArrayList<Integer> wegle = new ArrayList<>();
        ArrayList<Integer> bialko = new ArrayList<>();
        ArrayList<Integer> tluszcz = new ArrayList<>();
        ArrayList<Integer> kcal = new ArrayList<>();
        HashMap<Integer, String> product_to_makro = new HashMap<>();
        boolean break_while = false;
        int number_of_product = 0;

        while (!break_while) {
            //Option list
            System.out.println();
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
                    DisplayProducts(products, wegle, bialko, tluszcz, kcal, product_to_makro);
                    break;
                case 2:
                    AddProducts(products, wegle, bialko, tluszcz, kcal, number_of_product, product_to_makro);
                    number_of_product++;
                    break;
                case 3:
                    DeleteProducts(products, wegle, bialko, tluszcz, kcal, number_of_product, product_to_makro);
                    number_of_product--;
                    break;
                case 4:
                    break_while = true;
                default:
                    System.out.println("Lack of option");
                    break;
            } //Switch
        } //While
    } //Function



    static void DisplayProducts(ArrayList<String> products,ArrayList<Integer> wegle,ArrayList<Integer> bialko,ArrayList<Integer> tluszcz,ArrayList<Integer> kcal, HashMap<Integer, String> product_to_makro) {
        System.out.println("Lista produktow --> " + products);
        //Sumowanie makro
        for (int i = 0; i <= 3; i++) {
            switch (i) {
                case 0 -> System.out.println("Ilosc weglowodanow " + Liczenie_makro(wegle));
                case 1 -> System.out.println("Ilosc bialka: " + Liczenie_makro(bialko));
                case 2 -> System.out.println("Ilosc tluszczu: " + Liczenie_makro(tluszcz));
                case 3 -> System.out.println("Ilosc kalorii: " + Liczenie_makro(kcal));
            }
        }
        System.out.println(product_to_makro);
        System.out.println("Wegle" + wegle + "\nbialka" + bialko + "\ntluszcz" + tluszcz + "\nKcal" + kcal);
    }



    static void AddProducts(ArrayList<String> products,ArrayList<Integer> wegle,ArrayList<Integer> bialko,ArrayList<Integer> tluszcz,ArrayList<Integer> kcal, int number_of_product, HashMap<Integer, String> product_to_makro) {
        //Tworzenie produktu
        Scanner scan = new Scanner(System.in);
        System.out.println("Jaki produkt chcesz dodac?");
        String object = scan.nextLine();
        products.add(object);

        //Tworzenie makro
        System.out.println("Proszę podac wegle, bialko, tluszcz");
        System.out.println("NOP" + number_of_product);
        for (int i=0; i<=2; i++){
            int object2 = scan.nextInt();
            switch (i) {
                case 0 -> wegle.add(number_of_product, object2);
                case 1 -> bialko.add(number_of_product, object2);
                case 2 -> tluszcz.add(number_of_product, object2);
            } //Switch
        } //For
        kcal.add(number_of_product, (wegle.get(number_of_product)*4+bialko.get(number_of_product)*4+tluszcz.get(number_of_product)*9));
        product_to_makro.put(number_of_product,object);
    } //Function



    static void DeleteProducts(ArrayList<String> products,ArrayList<Integer> wegle,ArrayList<Integer> bialko,ArrayList<Integer> tluszcz,ArrayList<Integer> kcal, int number_of_product, HashMap<Integer, String> product_to_makro) {
        //Usuwanie produktu
        Scanner scan = new Scanner(System.in);
        System.out.println("Który produkt chcesz usunac?");
        String object = scan.next();
        products.remove(object);

        //Usuwanie makro
        int index = Find_Value_Of_Product(object, product_to_makro);

        for (int i=0; i<=3; i++){
            switch (i) {
                case 0 -> wegle.remove(index);
                case 1 -> bialko.remove(index);
                case 2 -> tluszcz.remove(index);
                case 3 -> kcal.remove(index);
            } //Switch
        } //For
        product_to_makro.remove(index);
    }

    static Integer Liczenie_makro(ArrayList<Integer> makro)
    {
        int sum = 0;
        for (Integer integer : makro) {
            sum += integer;
        }
        return sum;
    }

    static Integer Find_Value_Of_Product(String object, HashMap<Integer, String> product_to_makro) {
        int value_of_product = 0;
        for (Map.Entry<Integer, String> entry : product_to_makro.entrySet()) {
            if (entry.getValue().equals(object)) {
                value_of_product = entry.getKey();
            }
        }
        return value_of_product;
    }




















}








/*
Lista produktow
Dodawanie produktow
Usuwanie produktow
Liczenie makro i kcal

TODO
Index sortowanie
"""

 */


