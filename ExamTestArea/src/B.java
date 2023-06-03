public class B extends A{
    public B(int x) {
        super(x);
        info(x);
    }
    public void info(int z) {
        System.out.println("Nota " + z/2);
    }
}