package multiple_inheritance;

public class Fablet implements Phone, Tablet {
    @Override
    public void takeCalls() {
        System.out.print("I am a Samsung Galaxy note.");

    }

    @Override
    public void takeNotes() {
        System.out.print("I can make calls and take notes.");

    }
}
