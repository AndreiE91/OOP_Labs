class Nebun extends PiesaSah {

    public Nebun(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        //verifica daca nebunul se muta doar pe diagonala
        if (Math.abs(new_coordX - coordX) != Math.abs(new_coordY - coordY)) {
            System.out.println("Mutare invalida!");
            return false;
        }
        if(tablaSah[new_coordX][new_coordY] != null) {
            System.out.println("Mutare invalida!");
            return false;
        }
        int xDiff = new_coordX - coordX;
        int yDiff = new_coordY - coordY;
        int xDirection = xDiff / Math.abs(xDiff);
        int yDirection = yDiff / Math.abs(yDiff);

        int checkX = coordX + xDirection;
        int checkY = coordY + yDirection;

        while (checkX != new_coordX) {
            if (tablaSah[checkX][checkY] != null) { //verifica daca ceva blocheaza calea
                System.out.println("Mutare invalida, cale blocata de alta piesa!");
                return false;
            }
            checkX += xDirection;
            checkY += yDirection;
        }
        tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
        tablaSah[coordX][coordY] = null;
        coordX = new_coordX;
        coordY = new_coordY;
        System.out.println("Piesa " + numePiesa + " s-a mutat la x=" + new_coordX + ", y=" + new_coordY);
        return true;
    }

    @Override
    public boolean atacaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        //verifica daca nebunul se muta doar pe diagonala
        if (Math.abs(new_coordX - coordX) != Math.abs(new_coordY - coordY)) {
            System.out.println("Atac invalid!");
            return false;
        }
        //verifica daca nu exista o piesa inamica de atacat pe noua pozitie, in caz ca nu exista termina aici
        if(tablaSah[new_coordX][new_coordY] == null || tablaSah[new_coordX][new_coordY].culoare == culoare) {
            System.out.println("Nu este nimic de atacat acolo!");
            return false;
        }
        int xDiff = new_coordX - coordX;
        int yDiff = new_coordY - coordY;
        int xDirection = xDiff / Math.abs(xDiff);
        int yDirection = yDiff / Math.abs(yDiff);

        int checkX = coordX + xDirection;
        int checkY = coordY + yDirection;

        while (checkX != new_coordX) {
            if (tablaSah[checkX][checkY] != null) { //verifica daca ceva blocheaza calea
                System.out.println("Atac invalid, cale blocata de alta piesa!");
                return false;
            }
            checkX += xDirection;
            checkY += yDirection;
        }
        System.out.println("Piesa " + numePiesa + " a distrus piesa " + tablaSah[new_coordX][new_coordY].getNumePiesa() + " la x=" + new_coordX + ", y=" + new_coordY);
        tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
        tablaSah[coordX][coordY] = null;
        coordX = new_coordX;
        coordY = new_coordY;
        return true;
    }
}