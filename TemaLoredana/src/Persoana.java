public class Persoana implements Comparable<Persoana>{
    private String prenume, numeDeFamilie;

    public Persoana(String prenume, String numeDeFamilie) {
        this.prenume = prenume;
        this.numeDeFamilie = numeDeFamilie;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumeDeFamilie() {
        return numeDeFamilie;
    }

    public void setNumeDeFamilie(String numeDeFamilie) {
        this.numeDeFamilie = numeDeFamilie;
    }

    @Override
    public String toString() {
        return new String(prenume + " " + numeDeFamilie);
    }

    @Override
    public int compareTo(Persoana other) {
        int nameComparison = numeDeFamilie.compareTo(other.getNumeDeFamilie());
        if (nameComparison != 0) {
            return nameComparison; // In caz ca nu sunt la fel numele de familie, ne oprim aici
        }
        return prenume.compareTo(other.getPrenume()); // Daca sunt egale, atunci comparam dupa prenume
    }
}
