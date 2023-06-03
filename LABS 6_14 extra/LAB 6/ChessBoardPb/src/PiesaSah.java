abstract class PiesaSah {
    protected String numePiesa;
    protected int coordX;
    protected int coordY;
    protected CuloarePiesa culoare;
    protected PiesaSah[][] tablaSah;

    public PiesaSah(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        this.numePiesa = numePiesa;
        this.coordX = coordX;
        this.coordY = coordY;
        this.culoare = culoare;
        this.tablaSah = tablaSah;
    }

    public PiesaSah[][] getTablaSah() {
        return tablaSah;
    }

    public void setTablaSah(PiesaSah[][] tablaSah) {
        this.tablaSah = tablaSah;
    }

    public String getNumePiesa() {
        return numePiesa;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setNumePiesa(String numePiesa) {
        this.numePiesa = numePiesa;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public CuloarePiesa getCuloare() {
        return culoare;
    }

    public void setCuloare(CuloarePiesa culoare) {
        this.culoare = culoare;
    }

    public static void printTabla(PiesaSah[][] tablaSah) {
        System.out.println("\n********Tabla de sah********");
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                if(tablaSah[i][j] != null) {
                    System.out.println("Piesa de culoare " + (tablaSah[i][j].getCuloare() == CuloarePiesa.ALB ? "alba " : "neagra ") + tablaSah[i][j].getNumePiesa() + " pe pozitia(" + i + "," + j + ")");
                }
            }
        }
        System.out.println("\n");
    }

    public abstract boolean mutaPiesa(int new_coordX, int new_coordY);
    public abstract boolean atacaPiesa(int new_coordX, int new_coordY);

    protected boolean isWithinBounds(int new_coordX, int new_coordY) {
        if(new_coordX < 0 || new_coordX >= tablaSah.length || new_coordY < 0 || new_coordY >= tablaSah.length) {
            return false;
        }
        return true;
    }

}