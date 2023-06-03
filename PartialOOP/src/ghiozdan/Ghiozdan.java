package ghiozdan;

public class Ghiozdan {
    private Rechizita[] rechizite;
    int index = 0;

    public Ghiozdan(int numarRechizite) {
        this.rechizite = new Rechizita[numarRechizite];
    }

    public Rechizita[] getRechizite() {
        return rechizite;
    }

    public void setRechizite(Rechizita[] rechizite) {
        this.rechizite = rechizite;
    }

    public void add(Caiet caiet) {
        if(index < rechizite.length) {
            rechizite[index++] = caiet;
            System.out.println("Caietul: " + caiet.getEticheta() + " a fost adaugat");
        } else {
            System.out.println("Caietul: " + caiet.getEticheta() + " nu a fost adaugat");
        }
    }
}
