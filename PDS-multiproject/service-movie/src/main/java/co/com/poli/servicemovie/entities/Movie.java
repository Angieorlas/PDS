package co.com.poli.servicemovie.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotEmpty(message = "El título de la película no debe ir vacío")
    @Column(name="title", nullable = false)
    private String title;

    @NotEmpty(message = "El nombre del director no debe ir vacío")
    @Column(name="director", nullable = false)
    private String director;

    //@Min(1)
    //@Max(5)
    @Range(min = 1, max = 5, message = "El rating debe estar entre 1 y 5")
    @Column(name="rating", nullable = false)
    private Integer rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

