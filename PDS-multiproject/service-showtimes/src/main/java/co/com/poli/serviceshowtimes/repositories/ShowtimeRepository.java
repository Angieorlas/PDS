package co.com.poli.serviceshowtimes.repositories;

import co.com.poli.serviceshowtimes.entities.Showtime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findByShowtime(Showtime showtime);
}
