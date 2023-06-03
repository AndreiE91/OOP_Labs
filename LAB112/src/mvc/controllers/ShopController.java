package mvc.controllers;

import mvc.models.Candy;
import mvc.models.Shop;
import mvc.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopController {
    private ShopView view;
    private Shop shop;

    public ShopController(ShopView view, Shop shop) {
        this.view = view;
        this.shop = shop;

        // step 3
        // legam listenerul facut de noi de acel buton
        this.view.addShowListener(new ShowListener());

        //step 22
        //adaugam aici listenerul ca e mai frumos sa fie langa cel de sus
        this.view.addCreateButtonListener(new CreateListener());

        //step 17 expresii Lambda(varianta fara inner class,
        // mai scurta)
        //(parametrii) -> {logica ce manipuleaza parametrii}
        this.view.addTotalButtonListener((event) -> {
            //step 18
            //facem suma candy-urilor din shop
            double totalSum = 0;
            for(int i = 0; i < shop.getCandies().size(); ++i) {
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
    class ShowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Step 14
            //punem aici ce vrem sa se intample cand apasam pe show
            view.setShowTextArea(shop.getCandies().toString());
        }
    }

    //step 20
    //facem logica pt create
    class CreateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = view.getNameTextField();
                double price = view.getPriceTextField();

                //facem un obiect de tip Candy
                Candy candy = new Candy(name, price);

                //adaugam obiectul in lista de candies a shop-ului nostru
                shop.getCandies().add(candy);
                //step 27
                //resetam fieldurile
                view.cleanCreateField();
            } catch (Exception exception) {
                //step 23
                //prindem exceptii
                view.showErrorMessage("Bad input :(");
            }
        }
    }

}
