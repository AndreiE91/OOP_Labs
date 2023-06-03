public class PersonDeep implements Comparable<PersonDeep>, Cloneable{
    private String firstName;
    private String lastName;
    private int age;

    private CarDeep car;

    public PersonDeep(String firstName, String lastName, int age, CarDeep car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.car = car;
    }

    public CarDeep getCar() {
        return car;
    }

    public void setCar(CarDeep car) {
        this.car = car;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonDeep personDeep = (PersonDeep) super.clone();
        personDeep.car = (CarDeep)car.clone();
        return personDeep;
    }

    @Override
    public int compareTo(PersonDeep p) {
        if(this.age < p.age) {
            return -1;
        }else if(this.age > p.age) {
            return 1;
        } else {
            return 0;
        }
    }
}
