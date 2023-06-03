class Regina extends PiesaSah {

    public Regina(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        //verifica daca regina se muta doar pe diagonala sau verticala/orizontala
        if (Math.abs(new_coordX - coordX) != Math.abs(new_coordY - coordY) && coordX != new_coordX && coordY != new_coordY) {
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
        if(coordX == new_coordX) {
            int start = Math.min(coordY, new_coordY);
            int end = Math.max(coordY, new_coordY);
            for(int i = start + 1; i < end; ++i) {
                if(tablaSah[coordX][i] != null) {
                    System.out.println("Mutare invalida, cale blocata de alta piesa!");
                    return false; //cale blocata
                }
            }
        } else if(coordY == new_coordY){
            int start = Math.min(coordX, new_coordX);
            int end = Math.max(coordX, new_coordX);
            for(int i = start + 1; i < end; ++i) {
                if(tablaSah[i][coordY] != null) {
                    System.out.println("Mutare invalida, cale blocata de alta piesa!");
                    return false; //cale blocata
                }
            }
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
        //verifica daca regina ataca doar pe diagonala sau verticala/orizontala
        if (Math.abs(new_coordX - coordX) != Math.abs(new_coordY - coordY) && coordX != new_coordX && coordY != new_coordY) {
            System.out.println("Atac invalid!");
            return false;
        }
        //verifica daca nu exista o piesa inamica de atacat pe noua pozitie, in caz ca nu exista termina aici
        if (tablaSah[new_coordX][new_coordY] == null || tablaSah[new_coordX][new_coordY].culoare == culoare) {
            System.out.println("Nu este nimic de atacat acolo!");
            return false;
        }
        if (coordX == new_coordX) {
            int start = Math.min(coordY, new_coordY);
            int end = Math.max(coordY, new_coordY);
            for (int i = start + 1; i < end; ++i) {
                if (tablaSah[coordX][i] != null) {
                    System.out.println("Atac invalid!");
                    return false; //cale blocata
                }
            }
        } else if (coordY == new_coordY) {
            int start = Math.min(coordX, new_coordX);
            int end = Math.max(coordX, new_coordX);
            for (int i = start + 1; i < end; ++i) {
                if (tablaSah[i][coordY] != null) {
                    System.out.println("Atac invalid!");
                    return false; //cale blocata
                }
            }
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