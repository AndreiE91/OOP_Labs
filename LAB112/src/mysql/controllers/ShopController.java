package mysql.controllers;

import mysql.DatabaseConnection;
import mysql.models.Candy;
import mysql.models.Shop;
import mysql.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShopController {
    private ShopView view;
    private Shop shop;

    //step 1
    private DatabaseConnection databaseConnection;

    //step 2
    public ShopController(ShopView view, Shop shop, DatabaseConnection databaseConnection) {
        this.view = view;
        this.shop = shop;
        this.databaseConnection = databaseConnection;

        // step 3
        // legam listenerul facut de noi de acel buton
        this.view.addShowListener(new ShowListener());

        //step 22
        //adaugam aici listenerul ca e mai frumos sa fie langa cel de sus
        this.view.addCreateButtonListener(new InsertListener());

        //step 17 expresii Lambda(varianta fara inner class,
        // mai scurta)
        //(parametrii) -> {logica ce manipuleaza parametrii}
        this.view.addTotalButtonListener((event) -> {
            //step 18
            //facem suma candy-urilor din shop
            double totalSum = 0;
            for (int i = 0; i < shop.getCandies().size(); ++i) {
                totalSum += shop.getCandies().get(i).getPrice();
            }

            // step 19
            //vrem sa setam totalSum pe interfata

            view.setTotalTextField(totalSum);
        });
    }

    // step 1
    // facem un listener pt butonul SHOW
    // inner class (o clasa in interiorul altei clase)
    // nu o sa avem nevoie de public cand o declaram
    //step 4* redenumim in SelectListener pe ShowListener (R din CRUD)
    class ShowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                shop.getCandies().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM candies";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    int id = result.getInt(1);
                    String name = result.getString(2);
                    double price = result.getDouble(3);
                    shop.getCandies().add(new Candy(name, price, id));
                }
                view.setShowTextArea(shop.getCandies().toString());
                connection.close();
            } catch (Exception ex) {
                view.showErrorMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }


    class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //facem o conexiune spre baza noastra de date
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into candies (name, price)" + "values (?, ?)");
                preparedStatement.setString(1, view.getNameTextField());
                preparedStatement.setDouble(2, view.getPriceTextField());
                //preparedStatement.setInt(1, shop.getCandies().size() + 1);

                preparedStatement.executeUpdate();
                connection.close();
                //view.showErrorMessage("Candy successfully added!");
            } catch (Exception ex) {
                view.showErrorMessage("Bad input!");
            }
        }
    }
}
