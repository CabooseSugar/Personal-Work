package exercise5;

import java.text.DecimalFormat;

public class Pizza {
    public static void main(String[] args) {
        // Constructing pizzas and printing results with getDescription()
        Pizza test1 = new Pizza('M', 2, 4, 5);
        System.out.println(test1.getDescription());
        Pizza test2 = new Pizza('s', 1, 0, 2);
        System.out.println(test2.getDescription());
        Pizza test3 = new Pizza('L', 2, 2, 2);
        System.out.println(test3.getDescription());

    }

    // INSTANCE DATA
    private char size;
    private int cheeseNum, pepperNum, hamNum;

    // CONSTRUCTOR
    public Pizza(char size, int cheeseNum, int pepperNum, int hamNum) {
        this.size = size;
        this.cheeseNum = cheeseNum;
        this.pepperNum = pepperNum;
        this.hamNum = hamNum;
    }

    // ACCESSOR METHODS
    public char getSize() {
        return size;
    }

    public int getCheeseNum() {
        return cheeseNum;
    }

    public int getPepperNum() {
        return pepperNum;
    }

    public int getHamNum() {
        return hamNum;
    }

    public String getDescription()
    {
        String desc;
        DecimalFormat df = new DecimalFormat(".00");

        if (this.size == 'S' || this.size == 's')
            desc = "Size: Small - Cheese Slices: " + this.cheeseNum + " - Pepperoni Slices: "
                    + this.pepperNum + " - Ham Slices: " + this.hamNum + " - Cost: $" + df.format(calcCost());
        else if (this.size == 'M' || this.size == 'm')
            desc = "Size: Medium - Cheese Slices: " + this.cheeseNum + " - Pepperoni Slices: "
                    + this.pepperNum + " - Ham Slices: " + this.hamNum + " - Cost: $" + df.format(calcCost());
        else
            desc = "Size: Large - Cheese Slices: " + this.cheeseNum + " - Pepperoni Slices: "
                    + this.pepperNum + " - Ham Slices: " + this.hamNum + " - Cost: $" + df.format(calcCost());

        return desc;
    }

    // MUTATOR METHODS
    public void setSize(char size) {
        this.size = size;
    }

    public void setCheeseNum(int cheeseNum) {
        this.cheeseNum = cheeseNum;
    }

    public void setPepperNum(int pepperNum) {
        this.pepperNum = pepperNum;
    }

    public void setHamNum(int hamNum) {
        this.hamNum = hamNum;
    }

    public double calcCost()
    {
        double result = 0;

        if (this.size == 'S' || this.size == 's')
            result += 10;
        if (this.size == 'M' || this.size == 'm')
            result += 12;
        if (this.size == 'L' || this.size == 'l')
            result += 14;

        result += this.cheeseNum * 2;
        result += this.pepperNum * 2;
        result += this.hamNum * 2;

        return result;
    }
}

/*
Size: Medium - Cheese Slices: 2 - Pepperoni Slices: 4 - Ham Slices: 5 - Cost: $34.00
Size: Small - Cheese Slices: 1 - Pepperoni Slices: 0 - Ham Slices: 2 - Cost: $16.00
Size: Large - Cheese Slices: 2 - Pepperoni Slices: 2 - Ham Slices: 2 - Cost: $26.00
 */

