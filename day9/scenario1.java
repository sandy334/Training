//Perform  a selection sort for a movie rating app highlighiting the rating of the users based on the movie title  
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class scenario1 {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", 8.8),
            new Movie("The Dark Knight", 9.0),
            new Movie("Interstellar", 8.6),
            new Movie("Pulp Fiction", 8.9)
        );

        List<Movie> sortedMovies = movies.stream()
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
            .collect(Collectors.toList());

        sortedMovies.forEach(movie -> 
            System.out.println(movie.getTitle() + ": " + movie.getRating())
        );
    }
}

class Movie {
    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }
}
//