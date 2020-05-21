package static_keyword;

public class Tree_Test {

    public static void main(String[] args) {

        Tree pine = new Tree("pine");
        Tree maple = new Tree("maple");
        Tree oak = new Tree("oak");
        System.out.format("There are %d trees instantiated", Tree.NUM_TREES);
    }
}
