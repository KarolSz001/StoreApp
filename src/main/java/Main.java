import api.ProductFacade;
import api.ProductService;
import api.UserRegisterLoginFacade;
import enums.Color;
import enums.Material;
import facade.ProductFacadeImpl;
import facade.UserRegisterLoginFacadeImpl;
import model.Boots;
import model.Product;
import model.Tshirt;
import model.User;
import model.parser.ColorParser;
import model.parser.MaterialParser;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductFacade productFacade = ProductFacadeImpl.getInstance();

        boolean appOn = true;
        boolean loogedOn = false;
        int read;

        final String appName = "StoreApp01 v0.9 10.05.2019 _K.Szot";
        System.out.println(appName);

        while (appOn) {
            startMenu();
            read = scanner.nextInt();

            switch (read) {

                case 1:
                    System.out.println(" GIVE LOGIN ");
                    String loginLog = scanner.next();
                    System.out.println(" GIVE PASS ");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loogedOn = true;
                        System.out.println(" YOU ARE LOGGED");
                    } else {
                        System.out.println(" WRONG LOGIN ");
                    }
                    break;

                case 2:
                    System.out.println(" GIVE LOGIN: ");
                    String loginReg = scanner.next();
                    System.out.println(" GIVE ME PASS ");
                    String passworReg = scanner.next();
                    User user = new User(1, loginReg, passworReg);
                    userFacade.registerUser(user);

                case 0:
                    appOn = false;
                    break;
            }
        }
        while (loogedOn) {
            loggedMenu();
            read = scanner.nextInt();
            switch (read) {
                case 1:
                    productMenu();
                    read = scanner.nextInt();
                    Product product = null;
                    switch (read) {
                        case 1:
                            product = createBootsProduct();
                            break;
                        case 2:
                            product = createTshirtProduct();
                            break;
                        case 3:
                            product = createOtherProduct();
                            break;
                    }

                    System.out.println(productFacade.createProduct(product));
                case 2:
                    System.out.println("Available products: " + productFacade.getAllProducts());
                    System.out.println("Give name's product to remove ");
                    String productName = scanner.next();
                    System.out.println(productFacade.removeProduct(productName));
                    break;
                case 3:
                    System.out.println("Available products" + productFacade.getAllProducts());
                    break;
                case 0:
                    loogedOn = false;
                    break;
            }
        }
    }

    public static Product createOtherProduct() {
        String productName;
        Color color;
        Float price, weight;
        Integer count;

        System.out.println(" ProductName: ");
        productName = scanner.next();

        System.out.println(" Price: ");
        price = scanner.nextFloat();

        System.out.println(" Weight: ");
        weight = scanner.nextFloat();

        System.out.println(" Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        color = ColorParser.convertStringToColor(scanner.nextLine());

        System.out.println(" Count: ");
        count = scanner.nextInt();

        return new Product(1, productName, new BigDecimal(price), weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName;
        Float price, weight;
        Integer count, size;
        Boolean isNaturalSkin;
        System.out.println("ProductName: ");
        productName = scanner.next();
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println(" Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        Color color = ColorParser.convertStringToColor(scanner.nextLine());
        System.out.println("Count: ");
        count = scanner.nextInt();
        System.out.println("Size: ");
        size = scanner.nextInt();
        System.out.println("Is natural skin: ");
        isNaturalSkin = scanner.nextBoolean();
        return new Boots(1, productName, new BigDecimal(price), weight, color, count, size, isNaturalSkin);
    }

    public static Product createTshirtProduct() {
        String productName;
        Color color;
        String size;
        Material material;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName = scanner.next();
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW ");
        color = ColorParser.convertStringToColor(scanner.nextLine());
        System.out.println("Count: ");
        count = scanner.nextInt();
        System.out.println("Size: ");
        size = scanner.next();
        System.out.println("Material: ");
        material = MaterialParser.convertStringToMaterial(scanner.next());
        return new Tshirt(1, productName, new BigDecimal(price), weight, color, count, size, material);
    }


    public static void startMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1 - LOGIN ");
        System.out.println("2 - SIGIN");
        System.out.println("0 - EXIT");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - ADD NEW PRODUCT");
        System.out.println("2 - REMOVE PRODUCT");
        System.out.println("3 - SHOW ALL PRODUCTS");
        System.out.println("0 - LOGIN OUT ");
    }

    public static void productMenu() {
        System.out.println("1 - ADD NEW BOOTS");
        System.out.println("2 - ADD NEW TSHIRT ");
        System.out.println("3 - OTHERS ");
    }
}
