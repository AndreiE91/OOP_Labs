package mysql;

import mysql.controllers.ShopController;
import mysql.models.Candy;
import mysql.models.Shop;
import mysql.views.ShopView;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //step 3
        //updatam main-ul

        Shop shop = new Shop("Leonidas");

        ShopView view = new ShopView();

        DatabaseConnection databaseConnection = new DatabaseConnection();

        ShopController shopController = new ShopController(view, shop, databaseConnection);
    }
}
