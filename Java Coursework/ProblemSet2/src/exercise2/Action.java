package exercise2;

public class Action extends Movie {
    // CONSTRUCTOR
    public Action(String rating, int id, String title, int daysLate) {
        super(rating, id, title, daysLate);
    }

    // CALCULATES AND RETURNS LATE FEE OF MOVIE
    @Override
    public double calculateLateFees(){
        double fee = this.daysLate * 3.00; // Action fee is $3 a day
        return fee;
    }
}
