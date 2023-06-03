package models;

public class Main2 {
    public static void main(String[] args) {
        Scooter scooter = new Scooter(25);
        scooter.year = 2022;
        scooter.name = "trota";
        scooter.color = "green";

        scooter.setId(26);
        System.out.println(scooter.year + ", " + scooter.getId());
        System.out.println(scooter.name);
        System.out.println(scooter.color);
        System.out.println(Scooter.max_speed);

    }
}
