class Cal extends PiesaSah {

    public Cal(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    @Override
    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        int xDiff = Math.abs(new_coordX - coordX);
        int yDiff = Math.abs(new_coordY - coordY);

        if(tablaSah[new_coordX][new_coordY] != null) {
            System.out.println("Mutare invalida!");
            return false;
        }

        if ((xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2)) { // verifica daca mutarea este in forma de L
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
        //verifica daca nu exista o piesa inamica de atacat pe noua pozitie, in caz ca nu exista termina aici
        if(tablaSah[new_coordX][new_coordY] == null || tablaSah[new_coordX][new_coordY].culoare == culoare) {
            System.out.println("Nu este nimic de atacat acolo!");
            return false;
        }
        int xDiff = Math.abs(new_coordX - coordX);
        int yDiff = Math.abs(new_coordY - coordY);

        if ((xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2)) { // verifica daca mutarea este in forma de L
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