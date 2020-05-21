package shallow_deep_copy;

public class PersonTest implements Cloneable {

    public static void main(String[] args) throws  CloneNotSupportedException { // needs throws to get around .clone() error

        Person qb12 = new Person ("Tom", "Brady");
        Person rb = new Person ("Saquon", "Barkley");
        Person wr = new Person ("Josh", "Gordon");

        //
        // Make a copy of Tom Brady
        Person qb12copy = qb12; // this is a SHALLOW COPY (qb12copy points to same location in memory as qb12)
        // qb12copy.setFirstName("Tim"); // this affects Tom Brady's name to be Tim Brady even on original qb12 because
                                        // it changes the same object in memory

        // Two ways to create a deep copy in Java - implement interface "Cloneable" or use a copy constructor
        // Person qb12deepcopy = (Person)qb12.clone(); - DEEP copy using Cloneable .clone method
        Person qb12deepcopy = new Person(qb12); // - deep copy using copy constructor in Person.java. This is a lot cleaner than .clone() and is generally preferred.

        System.out.println(String.format("%s %s %s", qb12, rb, wr));

    }
}
