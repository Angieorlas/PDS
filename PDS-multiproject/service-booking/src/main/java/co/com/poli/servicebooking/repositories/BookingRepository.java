package co.com.poli.servicebooking.repositories;

import co.com.poli.servicebooking.entities.Booking;
import co.com.poli.servicebooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBookings(Booking booking);
    Booking findByUserId(Long id);

}
