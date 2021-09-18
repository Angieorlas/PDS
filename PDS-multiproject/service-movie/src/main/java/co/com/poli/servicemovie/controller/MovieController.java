package co.com.poli.servicemovie.controller;


import co.com.poli.commonslibrary.libraries.FormatMessage;
import co.com.poli.commonslibrary.libraries.Response;
import co.com.poli.commonslibrary.libraries.ResponseBuilder;
import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id, @RequestBody Movie movie,  BindingResult result){
        Movie movies = movieService.findById(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        movieService.delete(movies);
        return builder.success(movies);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> products = movieService.findAll();
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/movies/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie==null){
            return builder.success(null);
        }
        return builder.success(movie);
    }

}
