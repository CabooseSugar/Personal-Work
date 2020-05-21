package exercise2;

public class Comedy extends Movie {
    // CONSTRUCTOR
    public Comedy(String rating, int id, String title, int daysLate) {
        super(rating, id, title, daysLate);
    }

    // CALCULATES AND RETURNS LATE FEE OF MOVIE
    @Override
    public double calculateLateFees(){
        double fee = this.daysLate * 2.50; // Comedy fee is $2.50 a day
        return fee;
    }
}
