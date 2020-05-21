package exercise2;

import java.util.Objects;

public class Movie {

    // INSTANCE DATA
    private String rating;
    int id;
    String title;
    int daysLate;

    // CONSTRUCTOR
    public Movie(String rating, int id, String title, int daysLate) {
        this.rating = rating;
        this.id = id;
        this.title = title;
        this.daysLate = daysLate;
    }

    // GETTERS
    public String getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // SETTERS
    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     // EQUALS() AND HASHCODE()
    // equals() checks movie IDs specifically
    @Override
    public boolean equals(Object o) {
        Movie movie = (Movie) o;
        if (this.id == movie.id)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, id, title);
    }

    // CALCULATES AND RETURNS LATE FEE OF MOVIE (OVERRIDDEN BY CHILDREN)
    public double calculateLateFees(){
        double fee = this.daysLate * 2.00; // default fee is $2 per day
        return fee;
    }

    // PRINTS ALL MOVIE INFO
    public void printInfo(){
        System.out.println("Movie ID: " + this.id);
        System.out.println("Movie Title: " + this.title);
        System.out.println("MPAA Rating:" + this.rating);
        System.out.printf("Late fee: $%.2f \n", calculateLateFees());
    }
}
