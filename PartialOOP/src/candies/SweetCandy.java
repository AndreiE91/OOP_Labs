package candies;
public class SweetCandy extends Candy{
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
}
