package models;

public class Scooter {
    public int year;
    private int id; //ENCAPSULATION 1/4 OOP principles GET + SET
    protected String name;
    String color;
    public static int max_speed = 50;

    public Scooter(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

}
