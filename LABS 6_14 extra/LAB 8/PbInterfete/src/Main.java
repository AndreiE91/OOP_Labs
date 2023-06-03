import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persoana[] persoane = new Persoana[12];
        persoane[0] = new Persoana("John", "Cena", 40);
        persoane[1] = new Persoana("Marius", "Joldos", 54);
        persoane[2] = new Persoana("Diana", "Otrocol", 41);
        persoane[3] = new Persoana("Giorgi", "Rashvargaski", 27);
        persoane[4] = new Persoana("Paslau", "Loantocar", 20);
        persoane[5] = new Persoana("Pavel", "Eugen", 46);
        persoane[6] = new Persoana("Zoli", "Aurel", 30);
        persoane[7] = new Persoana("Aura", "Pop", 23);
        persoane[8] = new Persoana("Diana", "Irena", 32);
        persoane[9] = new Persoana("Calin", "Cenan", 42);
        persoane[10] = new Persoana("Traian", "Basescu", 71);
        persoane[11] = new Persoana("Raghu", "Ramakrischnan", 56);

        Arrays.sort(persoane);

        System.out.println("\nDupa sort:");
        for(Persoana p : persoane) {
            System.out.println(p.getNume() + " " + p.getPrenume() + " " + p.getVarsta());
        }
    }
}
