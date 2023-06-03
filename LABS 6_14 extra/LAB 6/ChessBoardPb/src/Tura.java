class Tura extends PiesaSah {

    public Tura(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    @Override
    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        //verifica daca tura se muta fie doar vertical fie doar orizontal
        if(coordX != new_coordX && coordY != new_coordY) {
            System.out.println("Mutare invalida!");
            return false;
        }
        //verifica orizontal/vertical daca blocat de o piesa in cale
        if(coordX == new_coordX) {
            int start = Math.min(coordY, new_coordY);
            int end = Math.max(coordY, new_coordY);
            for(int i = start + 1; i < end; ++i) {
                if(tablaSah[coordX][i] != null) {
                    System.out.println("Mutare invalida, cale blocata de alta piesa!");
                    return false; //cale blocata
                }
            }
        } else {
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
        //verifica daca tura ataca fie doar vertical fie doar orizontal
        if(coordX != new_coordX && coordY != new_coordY) {
            System.out.println("Atac invalid!");
            return false;
        }
        //verifica daca nu exista o piesa inamica de atacat pe noua pozitie, in caz ca nu exista termina aici
        if(tablaSah[new_coordX][new_coordY] == null || tablaSah[new_coordX][new_coordY].culoare == culoare) {
                System.out.println("Nu este nimic de atacat acolo!");
                return false;
        }
        //verifica orizontal/vertical daca este blocat de o alta piesa in cale
        if(coordX == new_coordX) {
            int start = Math.min(coordY, new_coordY);
            int end = Math.max(coordY, new_coordY);
            for(int i = start + 1; i < end; ++i) {
                if(tablaSah[coordX][i] != null) {
                    System.out.println("Exista o alta piesa in calea atacului!");
                    return false; //cale blocata
                }
            }
        } else {
            int start = Math.min(coordX, new_coordX);
            int end = Math.max(coordX, new_coordX);
            for(int i = start + 1; i < end; ++i) {
                if(tablaSah[i][coordY] != null) {
                    System.out.println("Exista o alta piesa in calea atacului!");
                    return false; //cale blocata
                }
            }
        }
        System.out.println("Piesa " + numePiesa + " a distrus piesa " + tablaSah[new_coordX][new_coordY].getNumePiesa() + " la x=" + new_coordX + ", y=" + new_coordY);
        tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
        tablaSah[coordX][coordY] = null;
        coordX = new_coordX;
        coordY = new_coordY;
        return true;
    }
}