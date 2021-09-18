package co.com.poli.servicemovie.repositories;

import co.com.poli.servicemovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
