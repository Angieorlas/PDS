package co.com.poli.serviceshowtimes.controller;


import co.com.poli.commonslibrary.libraries.FormatMessage;
import co.com.poli.commonslibrary.libraries.Response;
import co.com.poli.commonslibrary.libraries.ResponseBuilder;
import co.com.poli.serviceshowtimes.entities.Showtime;
import co.com.poli.serviceshowtimes.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping("/showtime")
    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @GetMapping("/showtime")
    public ResponseEntity<List<Showtime>> findAll() {

        List<Showtime> showtime = showtimeService.findAll();
        if (showtime.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(showtime);
    }

    @GetMapping("/showtime/{id}")
    public Response findById(@PathVariable("id") Long id,@RequestBody Showtime showtime, BindingResult result) {
        Showtime showtimes = showtimeService.findById(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        return builder.success(showtimes);
    }

    @PutMapping("/{id}")
    public Response update(@Valid @PathVariable("id") Long id, @RequestBody Showtime showtime, BindingResult result){
        Showtime showtimes = showtimeService.update(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        showtimes.setDate(showtime.getDate());
        showtimes.setIdMovies(showtime.getIdMovies());
        showtimeService.save(showtimes);
        return builder.success(showtimes);

    }
}