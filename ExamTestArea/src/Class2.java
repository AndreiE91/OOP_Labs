public class Class2 extends Class1{
    void hello() {
        System.out.println("hello from class2");
    }
    String str = "variable";
    public Class2() {
        //super();
        System.out.println("Class2 constructor was called");
        str += " b";
    }
}
