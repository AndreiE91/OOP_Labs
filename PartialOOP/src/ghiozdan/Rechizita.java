package ghiozdan;

public abstract class Rechizita {
    private String eticheta;
    public Rechizita(String eticheta) {
        this.eticheta = eticheta;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public abstract String getNume();
}
