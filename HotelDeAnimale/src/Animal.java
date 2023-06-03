public class Animal {
    private String nume;
    private int greutate;
    private Specie specie;

    public Animal(String nume, int greutate, Specie specie) {
        this.nume = nume;
        this.greutate = greutate;
        this.specie = specie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }
}
