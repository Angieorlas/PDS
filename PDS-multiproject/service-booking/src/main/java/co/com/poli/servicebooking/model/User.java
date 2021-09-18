package co.com.poli.servicebooking.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class User {

    private Long id;

    private String name;

    private String lastname;
}
