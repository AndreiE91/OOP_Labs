public class B extends A{
    @Override
    public void myMethod() throws MyException2 {
        throw new MyException2();
    }
}
