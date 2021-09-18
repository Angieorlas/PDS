package co.com.poli.serviceshowtimes.entities;

import co.com.poli.serviceshowtimes.model.Movie;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user", updatable = false, nullable = false, unique = true)
    @NotNull
    private Long id;

    @NotNull
    @Column(name="date")
    private Date date;

    @Column(name= "movies_id")
    private List<Long>idMovies;
    @Transient
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Objects.equals(id, showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
