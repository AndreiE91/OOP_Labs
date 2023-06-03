package calendar;

public class CalendarLucru {
    private Zi[] zile;

    public CalendarLucru() {
        this.zile = new Zi[]{
                new Zi("luni", true),
                new Zi("marti", true),
                new Zi("miercuri", true),
                new Zi("joi", true),
                new Zi("vineri", true),
                new Zi("sambata", false),
                new Zi("duminica", false)
        };
    }

    public Zi[] getZile() {
        return zile;
    }

    public void setZile(Zi[] zile) {
        this.zile = zile;
    }
}
