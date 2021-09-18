package co.com.poli.servicemovie.services;


import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {

        movieRepository.save(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {

        movieRepository.delete(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {

        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {

        return movieRepository.findById(id).orElse(null);
    }
}