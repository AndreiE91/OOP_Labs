import java.util.ArrayList;

public class Hotel {
    private int capacitateCaini;
    private int nrActualCaini;
    private int capacitatePisici;
    private int nrActualPisici;
    private double pretTotal;
    private ArrayList<Animal> animaleCazate;

    public Hotel(int capacitateCaini, int capacitatePisici, int pretTotal) {
        this.capacitateCaini = capacitateCaini;
        this.capacitatePisici = capacitatePisici;
        this.pretTotal = pretTotal;
        this.animaleCazate = new ArrayList<>();
    }

    public int getNrActualCaini() {
        return nrActualCaini;
    }

    public void setNrActualCaini(int nrActualCaini) {
        this.nrActualCaini = nrActualCaini;
    }

    public int getNrActualPisici() {
        return nrActualPisici;
    }

    public void setNrActualPisici(int nrActualPisici) {
        this.nrActualPisici = nrActualPisici;
    }

    public int getCapacitateCaini() {
        return capacitateCaini;
    }

    public void setCapacitateCaini(int capacitateCaini) {
        this.capacitateCaini = capacitateCaini;
    }

    public int getCapacitatePisici() {
        return capacitatePisici;
    }

    public void setCapacitatePisici(int capacitatePisici) {
        this.capacitatePisici = capacitatePisici;
    }

    public double getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(double pretTotal) {
        this.pretTotal = pretTotal;
    }

    public ArrayList<Animal> getAnimaleCazate() {
        return animaleCazate;
    }

    public void setAnimaleCazate(ArrayList<Animal> animaleCazate) {
        this.animaleCazate = animaleCazate;
    }

    boolean verificaLoc(Specie specie) {
        if(specie == Specie.CAINE) {
            if(nrActualCaini < capacitateCaini) {
                System.out.println("Da, este loc!");
                return true;
            } else {
                System.out.println("Nu, nu este loc!");
                return false;
            }
        } else {
            if(nrActualPisici < capacitatePisici) {
                System.out.println("Da, este loc!");
                return true;
            } else {
                System.out.println("Nu, nu este loc!");
                return false;
            }
        }
    }

    boolean addAnimal(Animal animal){
        if(verificaLoc(animal.getSpecie())) {
            if (animal.getSpecie() == Specie.CAINE) {
                ++nrActualCaini;
                pretTotal += 50 + 0.2 * animal.getGreutate();
                animaleCazate.add(animal);
                System.out.println("Caine adaugat cu succes!");
                return true;
            } else {
                ++nrActualPisici;
                pretTotal += 30;
                animaleCazate.add(animal);
                System.out.println("Pisica adaugata cu succes!");
                return true;
            }
        } else {
            System.out.println("Nu mai este loc in hotel!");
            return false;
        }
    }

    void spalaAnimal() {

    }
}
