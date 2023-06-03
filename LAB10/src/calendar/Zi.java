package calendar;

public class Zi {
    private String nume;
    private boolean esteLucratoare;

    public Zi(String nume, boolean esteLucratoare) {
        this.nume = nume;
        this.esteLucratoare = esteLucratoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean esteLucratoare() {
        return esteLucratoare;
    }

    public void setEsteLucratoare(boolean esteLucratoare) {
        this.esteLucratoare = esteLucratoare;
    }
}
