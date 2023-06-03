class Pion extends PiesaSah {

    public Pion(String numePiesa, int coordX, int coordY, CuloarePiesa culoare, PiesaSah[][] tablaSah) {
        super(numePiesa, coordX, coordY, culoare, tablaSah);
    }

    @Override
    public boolean mutaPiesa(int new_coordX, int new_coordY) {
        if(!isWithinBounds(new_coordX, new_coordY)) {
            System.out.println("Pozitie in afara tablei!");
            return false;
        }
        //verifica daca mutarea este valida pentru pion
        if(culoare == CuloarePiesa.ALB) { //doar alb se poate muta in sus cu pionul->creste Y
            if (coordX == new_coordX && coordY == new_coordY - 1 && tablaSah[new_coordX][new_coordY] == null) {
                tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
                tablaSah[coordX][coordY] = null;
                coordX = new_coordX;
                coordY = new_coordY;
                System.out.println("Piesa " + numePiesa + " s-a mutat la x=" + new_coordX + ", y=" + new_coordY);
                return true;
            }
        } else if(culoare == CuloarePiesa.NEGRU){
            if (coordX == new_coordX && coordY == new_coordY + 1 && tablaSah[new_coordX][new_coordY] == null) {
                tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
                tablaSah[coordX][coordY] = null;
                coordX = new_coordX;
                coordY = new_coordY;
                System.out.println("Piesa " + numePiesa + " s-a mutat la x=" + new_coordX + ", y=" + new_coordY);
                return true;
            }
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
        //verifica daca atacul este valid pentru pion
        if(culoare == CuloarePiesa.ALB) { //doar alb poate ataca in sus diagonala cu pionul->creste Y
            if ((coordX == new_coordX - 1 || coordX == new_coordX + 1) && coordY == new_coordY - 1) {
                System.out.println("Piesa " + numePiesa + " a distrus piesa " + tablaSah[new_coordX][new_coordY].getNumePiesa() + " la x=" + new_coordX + ", y=" + new_coordY);
                tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
                tablaSah[coordX][coordY] = null;
                coordX = new_coordX;
                coordY = new_coordY;
                return true;
            }
        } else if(culoare == CuloarePiesa.NEGRU){
            if ((coordX == new_coordX - 1 || coordX == new_coordX + 1) && coordY == new_coordY + 1) {
                System.out.println("Piesa " + numePiesa + " a distrus piesa " + tablaSah[new_coordX][new_coordY].getNumePiesa() + " la x=" + new_coordX + ", y=" + new_coordY);
                tablaSah[new_coordX][new_coordY] = tablaSah[coordX][coordY];
                tablaSah[coordX][coordY] = null;
                coordX = new_coordX;
                coordY = new_coordY;
                return true;
            }
        }
        System.out.println("Atac invalid!");
        return false;
    }
}