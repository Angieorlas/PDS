package co.com.poli.servicebooking.controller;


import co.com.poli.commonslibrary.libraries.FormatMessage;
import co.com.poli.commonslibrary.libraries.Response;
import co.com.poli.commonslibrary.libraries.ResponseBuilder;
import co.com.poli.servicebooking.entities.Booking;
import co.com.poli.servicebooking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping("/bookings")
    public Response save(@Valid @RequestBody Booking booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        bookingService.delete(booking);
        return builder.success(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public Response delete(@PathVariable("id") Long id,@RequestBody Booking booking, BindingResult result){
        Booking bookings = bookingService.findById(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        bookingService.delete(bookings);
        return builder.success(bookings);
    }

    @GetMapping("/bookings")
    public Response findAll(@Valid @RequestBody Booking booking, BindingResult result){
        List<Booking> bookings = bookingService.findAll();
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        return builder.success(bookings);
    }

    @GetMapping("/bookings/{id}")
    public  Response findById(@PathVariable("id") Long id, @RequestBody Booking booking, BindingResult result){
        Booking bookings = bookingService.findById(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        return builder.success(bookings);
    }

}
