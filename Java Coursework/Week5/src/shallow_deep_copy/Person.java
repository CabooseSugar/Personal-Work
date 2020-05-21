package shallow_deep_copy;

public class Person {

    //
    // INSTANCE DATA
    private String firstName, lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // copy constructor
    public Person (Person otherPerson) {
        this.firstName = otherPerson.firstName;
        this.lastName = otherPerson.lastName;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException { // alt + enter override methods
        Person deepCopy = new Person (firstName, lastName);
        return deepCopy;
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
