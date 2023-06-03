public class Persoana implements Comparable<Persoana>{
    private String nume, prenume;
    private int varsta;

    Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    //sort alfabetic dupa prenume
//    @Override
//    public int compareTo(Persoana other) {
//        return this.prenume.compareTo(other.prenume);
//    }

    //sort dupa varsta
     @Override
     public int compareTo(Persoana other) {
       return Integer.compare(this.varsta, other.varsta);
     }
}
