
/**
 * Write a description of class Pozitie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Pozitie
{
    protected int[] pozitii=new int[6];
    public Pozitie()
    {
        pozitii=IOClass.citireFisier();
    }

    

    public int[] citestePozitie(){
        return pozitii;
    }


    public int[] citesteComanda()
    {
        int ret[]=new int[4];
        String line="";
        Scanner in=new Scanner(System.in);
        System.out.println("Dati numarul mautarii dupa cele posibile pe tabla de sah, de la 1 la 8!");
        int move=in.nextInt();
        int x=0, y=0;
        switch(move){
            case 1: x=-1; y=-2;
            break;
            case 2: x=-2; y=-1;
            break;
            case 3: x=-2; y=1;
            break;
            case 4: x=-1; y=2;
            break;
            case 5: x=1; y=2;
            break;
            case 6: x=2; y=1;
            break;
            case 7: x=2; y=-1;
            break;
            case 8: x=1; y=-2;
            break;
            case 9: System.exit(0);
            break;
            default: x=0; y=0;
            break;
        }
        ret[0]=pozitii[0];
        ret[1]=pozitii[1];
        ret[2]=ret[0]+x;
        ret[3]=ret[1]+y;
        return ret;
    }
}
