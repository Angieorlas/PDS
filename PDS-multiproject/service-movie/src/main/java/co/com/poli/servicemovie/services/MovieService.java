package co.com.poli.servicemovie.services;

import co.com.poli.servicemovie.entities.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);
    void delete(Movie movie);
    List<Movie> findAll();
    Movie findById(Long id);

}