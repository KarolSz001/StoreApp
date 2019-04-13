import dao.ProductDaoImpl;
import model.Boots;
import model.Product;
import model.Tshirt;
import model.User;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String []args) {
        final String appName = "StoreApp01 v0.6 07.04.2019 _K.Szot";
        System.out.println(appName);


        User user = new User(1, "admin", "admin");
        Tshirt tshirt = new Tshirt(1, "T-shirt", new BigDecimal(35.0), 0.3f, "Black", 10,"XL", "Cotton");
        Boots boots = new Boots(1, "High heels", new BigDecimal(99.0), .5f, "Red", 12, 35, true);

        List<Product> productList = new ArrayList<>();
        productList.add(tshirt);
        productList.add(boots);

        System.out.println(user.toString());
        System.out.println(tshirt.toString());
        System.out.println(boots.toString());

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(7);
        numbers.add(3);

        numbers.remove(1);
        numbers.size();
        ProductDaoImpl pdaoImpl = null;
        try {
            pdaoImpl = new ProductDaoImpl("data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pdaoImpl.saveProducts(productList);


    }
}
