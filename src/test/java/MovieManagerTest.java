import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.services.MovieManager;

import java.util.Arrays;
import java.util.List;

public class MovieManagerTest {
    @Test
    public void shouldFindAllMoviesWhenBelowLimit() {
        MovieManager movieManager = new MovieManager(5);
        movieManager.save("Бладшот");
        movieManager.save("Вперед");
        movieManager.save("Отель Белград");

        String[] actualMovies = movieManager.findAll();
        Assertions.assertEquals(3, actualMovies.length);
    }

    @Test
    public void shouldFindLastMoviesWhenAboveLimit() {
        MovieManager movieManager = new MovieManager(2);
        movieManager.save("Бладшот");
        movieManager.save("Вперед");
        movieManager.save("Отель Белград");

        String[] actualLastMovies = movieManager.findLast();
        String[] expectedLastMovies = {"Вперед", "Отель Белград"};
        Assertions.assertArrayEquals(expectedLastMovies, actualLastMovies);
    }

    @Test
    public void shouldSetLimitToFiveByDefault() {
        MovieManager movieManager = new MovieManager();

        movieManager.save("Бладшот");
        movieManager.save("Вперед");
        movieManager.save("Отель Белград");
        movieManager.save("Джентльмены");
        movieManager.save("Человек-невидимка");
        movieManager.save("Тролли. Мировой тур");

        String[] actualMovies = movieManager.findAll();

        Assertions.assertEquals(5, actualMovies.length);
    }
}
