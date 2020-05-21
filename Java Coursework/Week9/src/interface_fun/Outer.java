package interface_fun;

public interface Outer {
 // everything in interface will be public by default
    String firstName = null;

    void doIt();

    interface Inner { // including this interface, also public by default

    }

}
