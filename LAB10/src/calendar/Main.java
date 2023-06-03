package calendar;

public class Main {
    public static void main(String[] args) {
        Lucrator lucrator1 = new Lucrator("Ioana");
        try {
            lucrator1.lucreaza("joi");
        } catch(ExceptieZiNelucratoare e) {
            e.getMessage();
        }

        try {
            lucrator1.lucreaza("maine");
        } catch(ExceptieZiNelucratoare e) {
            e.getMessage();
        }

        try {
            lucrator1.lucreaza("sambata");
        } catch(ExceptieZiNelucratoare e) {
            System.out.println(e.getMessage());
        }
        Lucrator lucrator2 = null;
        try {
            lucrator2.lucreaza("sambata");
        //} catch(Exception e) {
        //    System.out.println("Exceptie random");
        } catch(ExceptieZiNelucratoare e) {
            System.out.println(e.getMessage());
        } catch(NullPointerException e) {
            System.out.println("Lucratorul este null");
        }
    }
}
