package static_keyword;

public class Tree {

    // STATIC VARIABLE (shared by the class)
    public static int NUM_TREES = 0;

    //
    // INSTANCE DATA
    private String type;
    private String leafColor;

    //Alt+ Insert to have IntelliJ generate constructor, get and sets for you
    public Tree(String type) {
        this.type = type;
        NUM_TREES++;
    }

    public String getType() {
        return type;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "type='" + type + '\'' +
                ", leafColor='" + leafColor + '\'' +
                '}';
    }
}
