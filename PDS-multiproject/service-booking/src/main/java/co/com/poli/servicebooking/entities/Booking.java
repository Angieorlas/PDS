package co.com.poli.servicebooking.entities;

import co.com.poli.servicebooking.model.Movie;
import co.com.poli.servicebooking.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="Bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_booking", updatable = false, nullable = false, unique = true)
    private Long id;


    @NotNull
    @Column(name="user_id", nullable = false)
    private Long userId;


    @NotNull
    @Column(name="showtime_id", nullable = false)
    private Long showtimeId;

    @Column(name = "movies_id")
    private Long movies_id;
    @Transient
    private Movie movie;
    @Transient
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
