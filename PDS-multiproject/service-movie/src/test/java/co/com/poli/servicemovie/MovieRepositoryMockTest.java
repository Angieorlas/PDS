package co.com.poli.servicemovie;


import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.repositories.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import co.com.poli.commonslibrary.libraries.Response;
import co.com.poli.commonslibrary.libraries.ResponseBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findMovieList_return_List(){

        Movie movie = Movie.builder()
                .title("Harry Potter")
                .director("David Yates")
                .rating(4)
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findAll();
        Assertions.assertThat(movies.size()).isEqualTo(2);
    }
}
