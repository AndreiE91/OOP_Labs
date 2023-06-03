public class Main {
    //tablaSah[0][0] este coltul din stanga jos. Atunci +y e sus, -y jos, +x dreapta si -x stanga
        public static void main(String[] args) {
            PiesaSah[][] tablaSah = new PiesaSah[8][8];
            tablaSah[1][0] = new Tura("TuraAlb1", 1, 0, CuloarePiesa.ALB, tablaSah);
            tablaSah[3][4] = new Pion("PionNegru1", 3, 4, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[3][3] = new Pion("PionNegru2", 3, 3, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[2][3] = new Pion("PionAlb1", 2, 3, CuloarePiesa.ALB, tablaSah);
            tablaSah[3][0] = new Tura("TuraNegru1", 3, 0, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[7][0] = new Tura("TuraNegru2", 7, 0, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[0][7] = new Nebun("NebunAlb1", 0, 7, CuloarePiesa.ALB, tablaSah);
            tablaSah[0][6] = new Nebun("NebunNegru1", 6, 6, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[4][4] = new Cal("CalAlb1", 4, 4, CuloarePiesa.ALB, tablaSah);
            tablaSah[7][5] = new Cal("CalNegru1", 7, 5, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[7][5] = new Cal("CalNegru1", 7, 5, CuloarePiesa.NEGRU, tablaSah);
            PiesaSah.printTabla(tablaSah);
            tablaSah[0][7].atacaPiesa(7, 0);
            //tablaSah[2][2] = new Pion("PionNegru2", 2, 2, CuloarePiesa.NEGRU);
            tablaSah[1][0].mutaPiesa(1, 7);
            tablaSah[1][7].mutaPiesa(7, 7);
            tablaSah[2][3].atacaPiesa(3, 4);
            //pun un pion negru in cale care sa blocheze calea de atac a turei
            tablaSah[3][0].atacaPiesa(3, 4);
            tablaSah[3][0].atacaPiesa(7, 0);
            //pun o alta piesa de acceasi culoare la destinatia atacului
            tablaSah[0][6].atacaPiesa(7,0);
            tablaSah[4][4].mutaPiesa(5, 6);
            tablaSah[5][6].atacaPiesa(7, 5);
            PiesaSah.printTabla(tablaSah);
            //creez o regina si ii blochez mai intai calea cu un pion, apoi il atac
            tablaSah[4][4] = new Regina("ReginaNegru1", 4, 4, CuloarePiesa.NEGRU, tablaSah);
            tablaSah[6][6] = new Pion("PionAlb2", 6, 6, CuloarePiesa.ALB, tablaSah);
            tablaSah[4][4].mutaPiesa(7, 7);
            tablaSah[4][4].atacaPiesa(7, 7);
            tablaSah[4][4].atacaPiesa(6, 6);
            tablaSah[6][6].atacaPiesa(7, 7);
            //incerc sa mut si sa atac in afara tablei
            tablaSah[3][4].mutaPiesa(100, 100);
            tablaSah[3][4].atacaPiesa(100, 100);
            PiesaSah.printTabla(tablaSah);
            tablaSah[7][6] = new Rege("RegeAlb1", 7, 6, CuloarePiesa.ALB, tablaSah);
            tablaSah[6][7] = new Rege("RegeNegru1", 6, 7, CuloarePiesa.NEGRU, tablaSah);
            //creez 2 regi de culori diferite, incerc sa ii atac intre ei,
            //apoi incerc sa atac in afara range-ului unui rege, apoi inauntru
            tablaSah[7][6].atacaPiesa(6, 7);
            tablaSah[7][6].atacaPiesa(7, 0);
            tablaSah[7][6].atacaPiesa(7, 7);
        }
}
