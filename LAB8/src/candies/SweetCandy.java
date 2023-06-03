package candies;
public class SweetCandy extends Candy implements Meltable{
    private String sweetenerType;


    public SweetCandy(String name, double price, String sweetenerType) {
        super(name, price);
        this.sweetenerType = sweetenerType;
    }


    public String getSweetenerType() {
        return sweetenerType;
    }

    public void setSweetenerType(String sweetenerType) {
        this.sweetenerType = sweetenerType;
    }

    @Override
    public void melt() {
        System.out.println("Sweet candy " + super.getName() + " was melted.");
    }
}
