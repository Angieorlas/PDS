package co.com.poli.servicemovie;

import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.repositories.MovieRepository;
import co.com.poli.servicemovie.services.MovieService;
import co.com.poli.servicemovie.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class MovieServerMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;


    @BeforeEach
    public void begin(){
    MockitoAnnotations.initMocks (this);
    movieService = new MovieServiceImpl(movieRepository);
    Movie movie = Movie.builder()
            .id(4L)
            .title("It")
            .director("James Wan")
            .rating(3)
            .build();
        Mockito.when(movieRepository.findById(4L)).thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_Movie() {
        Movie movie = movieService.findById(4L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("It");
    }

}
