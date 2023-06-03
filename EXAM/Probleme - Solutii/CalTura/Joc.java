
/**
 * Write a description of class Joc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joc
{
    public static void main(){
    Tabla sah=new Tabla();
    while(!sah.gameOver()){
    sah.view();
    sah.moveHorse();
    if(!sah.gameOver())sah.moveT();
    }
    sah.view();
    }
}
