public class PersonShallow implements Comparable<PersonShallow>, Cloneable{
    private String firstName;
    private String lastName;
    private int age;

    private CarShallow car;

    public PersonShallow(String firstName, String lastName, int age, CarShallow car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.car = car;
    }

    public CarShallow getCar() {
        return car;
    }

    public void setCar(CarShallow car) {
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
        return super.clone();
    }

    @Override
    public int compareTo(PersonShallow p) {
        if(this.age < p.age) {
            return -1;
        }else if(this.age > p.age) {
            return 1;
        } else {
            return 0;
        }
    }
}
