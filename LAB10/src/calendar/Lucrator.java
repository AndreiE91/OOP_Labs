package calendar;

public class Lucrator {
    private String nume;
    private CalendarLucru calendar;

    public Lucrator(String nume) {
        this.nume = nume;
        this.calendar = new CalendarLucru();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public CalendarLucru getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarLucru calendar) {
        this.calendar = calendar;
    }

    public void lucreaza(String numeZi) throws ExceptieZiNelucratoare{
        for(Zi zi : calendar.getZile()) {
            if(zi.getNume().equals(numeZi)) {
                if(zi.esteLucratoare()) {
                    System.out.println("Lucratorul " + nume + " lucreaza " + numeZi);
                } else {
                    throw new ExceptieZiNelucratoare("Exceptie: " + numeZi + " este o zi nelucratoare");
                }
                return;
            }
        }
        System.out.println(numeZi + " nu e o zi din calendar");
    }
}
