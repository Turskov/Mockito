import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.services.MovieManager;

import java.util.List;

public class MovieManagerTest {
    @Test
    public void shouldFindAllMoviesWhenBelowLimit() {
        MovieManager movieManager = new MovieManager(5);
        movieManager.save("Бладшот");
        movieManager.save("Вперед");
        movieManager.save("Отель Белград");

        List<String> actualMovies = movieManager.findAll();
        Assertions.assertEquals(3, actualMovies.size());
    }

    @Test
    public void shouldFindLastMoviesWhenAboveLimit() {
        MovieManager movieManager = new MovieManager(2);
        movieManager.save("Бладшот");
        movieManager.save("Вперед");
        movieManager.save("Отель Белград");

        List<String> actualLastMovies = movieManager.findLast();

        Assertions.assertEquals(2, actualLastMovies.size());
        Assertions.assertEquals("Вперед", actualLastMovies.get(0));
        Assertions.assertEquals("Отель Белград", actualLastMovies.get(1));
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

        List<String> actualMovies = movieManager.findAll();

        Assertions.assertEquals(5, actualMovies.size());
    }
}
