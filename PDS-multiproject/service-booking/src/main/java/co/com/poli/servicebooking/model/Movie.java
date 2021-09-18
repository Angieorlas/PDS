package co.com.poli.servicebooking.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class Movie {

    private Long id;

    private String title;

    private String director;

    private int rating;

}
