package exercise2;

public class MovieTest {
    public static void main(String[] args) {
        Movie defMovie = new Movie ("G", 1234, "Hercules", 4); // $2 fee a day
        Action actMovie = new Action("PG-13", 2222, "Spider-Man 2", 5); // $3 fee a day
        Comedy comMovie = new Comedy("PG-13", 5392, "The Naked Gun", 2); // $2.50 fee a day
        Drama dramMovie = new Drama("R", 5392, "Goodfellas", 6); // $2 fee a day

        defMovie.printInfo();
        System.out.println();
        actMovie.printInfo();
        System.out.println();
        comMovie.printInfo();
        System.out.println();
        dramMovie.printInfo();
    }

}

/*
Movie ID: 1234
Movie Title: Hercules
MPAA Rating:G
Late fee: $8.00

Movie ID: 2222
Movie Title: Spider-Man 2
MPAA Rating:PG-13
Late fee: $15.00

Movie ID: 5392
Movie Title: The Naked Gun
MPAA Rating:PG-13
Late fee: $5.00

Movie ID: 5392
Movie Title: Goodfellas
MPAA Rating:R
Late fee: $12.00

 */