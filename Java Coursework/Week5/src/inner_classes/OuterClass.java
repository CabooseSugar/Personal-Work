package inner_classes;

public class OuterClass {

    //
    private int num = 175;

    //
    // inner class
    public class InnerClass {
        public int getNum() {
            return num;
        }
    }

    //
    // static inner class (nested class)
    static class NestedClass {
        public void myMethod(){
            System.out.println("I am called inside the nested class");
        }
    }

    public static void main(String[] args) {

        //
        // Make instance of outer class
        OuterClass outer = new OuterClass();

        //
        // Make an instance of inner class
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println("NUM: " + inner.getNum());

        //
        // Make instance of nested class
        OuterClass.NestedClass nested = new OuterClass.NestedClass();
        nested.myMethod();
    }

}
