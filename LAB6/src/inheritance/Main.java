package inheritance;

public class Main {
    public static void main(String[] args) {
        Sub s = new Sub();
        Base b = s;



        // Regula generală este că variabila accesată
        // depinde de clasa la care s-a asignat tipul variabilei.



        System.out.println(s.field); //1
        System.out.println(b.field); //0
        System.out.println(((Sub) b).field); //1
        System.out.println(((Base) s).field); //0

        // Această aderare strictă la identitatea referinţă/instanţă faţă de tipul variabilei este sufletul polimorfismului.
        // Polimorfismul este caracteristica care deleagă comportamentul la
        // clasa reală a instanţei referite — nu la tipul în care este stocată referinţa.
        // Polimorfismul este legat numai de metode.



        System.out.println(s.getField()); // 1
        System.out.println(b.getField()); // 1
        System.out.println(((Sub)b).getField()); // 1
        System.out.println(((Base)s).getField()); // 1
    }
}
