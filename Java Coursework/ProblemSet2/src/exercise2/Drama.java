package exercise2;

public class Drama extends Movie{
    // CONSTRUCTOR
    public Drama(String rating, int id, String title, int daysLate) {
        super(rating, id, title, daysLate);
    }

    // CALCULATES AND RETURNS LATE FEE OF MOVIE
    @Override
    public double calculateLateFees(){
        double fee = this.daysLate * 2; // Comedy fee is $2 a day
        return fee;
    }


}
