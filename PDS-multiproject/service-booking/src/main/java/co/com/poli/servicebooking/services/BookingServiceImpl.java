package co.com.poli.servicebooking.services;

import co.com.poli.servicebooking.client.MovieClient;
import co.com.poli.servicebooking.client.UserClient;
import co.com.poli.servicebooking.entities.Booking;
import co.com.poli.servicebooking.model.User;
import co.com.poli.servicebooking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements  BookingService{


    private final UserClient userClient;
    private final MovieClient movieClient;
    private final BookingRepository bookingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {
       bookingRepository.save(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {

        bookingRepository.delete(booking);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll() ;
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {

        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByUser_id(Long userId)
    {
        Booking bookings= bookingRepository.findByUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        User user =
                modelMapper.map(
                        userClient.findById(bookings.getUserId()).getData(),
                        User.class);
        bookings.setUser(user);

        return bookingRepository.findByUserId(userId);
    }

}
