class Rege extends PiesaSah {

    public Rege(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    @Override
    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        if(tablaSah[new_coordX][new_coordY] != null) {
            System.out.println("Mutare invalida, pozitie ocupata de alta piesa!");
            return false;
        }
        //verifica daca mutarea este valida pentru rege
        if (Math.abs(new_coordX - coordX) <= 1 && Math.abs(new_coordY - coordY) <= 1) {
            tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
            tablaSah[coordX][coordY] = null;
            coordX = new_coordX;
            coordY = new_coordY;
            System.out.println("Piesa " + numePiesa + " s-a mutat la x=" + new_coordX + ", y=" + new_coordY);
            return true;
        }
        System.out.println("Mutare invalida!");
        return false;
    }
    @Override
    public boolean atacaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        if(tablaSah[new_coordX][new_coordY] == null) {
            System.out.println("Atac invalid, nu este nimic de atacat acolo!");
            return false;
        }
        //verifica daca mutarea este valida pentru rege
        if (Math.abs(new_coordX - coordX) <= 1 && Math.abs(new_coordY - coordY) <= 1) {
            if(tablaSah[new_coordX][new_coordY] instanceof Rege && tablaSah[new_coordX][new_coordY].culoare != culoare) {
                System.out.println("Nu se poate ataca un rege cu alt rege!");
                return false;
            }
            System.out.println("Piesa " + numePiesa + " a distrus piesa " + tablaSah[new_coordX][new_coordY].getNumePiesa() + " la x=" + new_coordX + ", y=" + new_coordY);
            tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
            tablaSah[coordX][coordY] = null;
            coordX = new_coordX;
            coordY = new_coordY;
            return true;
        }
        System.out.println("Atac invalid!");
        return false;
    }
}