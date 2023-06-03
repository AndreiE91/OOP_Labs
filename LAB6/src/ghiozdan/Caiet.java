package ghiozdan;

public class Caiet extends Rechizita{
    public Caiet(String eticheta) {
        super(eticheta);
    }

    @Override
    public String getNume() {
        return this.getEticheta() + " - caiet";
    }
}
