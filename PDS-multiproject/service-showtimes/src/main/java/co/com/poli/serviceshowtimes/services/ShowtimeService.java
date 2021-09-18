package co.com.poli.serviceshowtimes.services;

import co.com.poli.serviceshowtimes.entities.Showtime;

import java.util.List;

public interface ShowtimeService {

    void save(Showtime showtime);
    Showtime update(Long id);
    List<Showtime> findAll();
    Showtime findById(Long id);

}
