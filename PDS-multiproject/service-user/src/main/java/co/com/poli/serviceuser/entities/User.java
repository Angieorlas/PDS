package co.com.poli.serviceuser.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotEmpty(message = "El nombre del usuario no debe ir vacío")
    @Column(name="name_user", nullable = false)
    private String name;

    @NotEmpty(message = "El apellido del usuario no debe ir vacío")
    @Column(name="lastname_user", nullable = false)
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

