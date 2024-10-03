package dev.waiyanhtet.facilitybookingtest.service.impl;

import dev.waiyanhtet.facilitybookingtest.dto.BookingStatus;
import dev.waiyanhtet.facilitybookingtest.dto.request.BookingRequest;
import dev.waiyanhtet.facilitybookingtest.dto.response.BookingResponse;
import dev.waiyanhtet.facilitybookingtest.entity.BookingEntity;
import dev.waiyanhtet.facilitybookingtest.entity.FacilityEntity;
import dev.waiyanhtet.facilitybookingtest.exception.BusinessLogicException;
import dev.waiyanhtet.facilitybookingtest.mapper.BookingMapper;
import dev.waiyanhtet.facilitybookingtest.repository.BookingRepository;
import dev.waiyanhtet.facilitybookingtest.repository.CustomerRepository;
import dev.waiyanhtet.facilitybookingtest.repository.FacilityRepository;
import dev.waiyanhtet.facilitybookingtest.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final CustomerRepository customerRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        var optionalCustomer = customerRepository.findById(request.getCustomerId());
        if(optionalCustomer.isPresent()) {
            var facilityList = new ArrayList<FacilityEntity>();
            for(Long facilityId : request.getFacilityIds()) {
                var optionalFacility = facilityRepository.findById(facilityId);
                optionalFacility.ifPresent(facilityList::add);
            }
            var bookingEntity = new BookingEntity();
            bookingEntity.setFacilities(facilityList);
            bookingEntity.setCustomer(optionalCustomer.get());
            bookingEntity.setBookingStatus(BookingStatus.PENDING);
            bookingEntity.setBookingTime(LocalDateTime.now());
            bookingEntity.setDescription(request.getDescription());
            var booking = bookingRepository.save(bookingEntity);
            return bookingMapper.asBookingResponse(booking);
        }
        throw new BusinessLogicException(HttpStatus.BAD_REQUEST, HttpStatus.NOT_FOUND.value(), "Customer not found");
    }

    @Override
    public List<BookingResponse> retrieveBooking(Long customerId) {
        var bookingList = bookingRepository.findAll();
        return bookingList.stream().map(bookingMapper::asBookingResponse).toList();
    }

    @Override
    public BookingResponse updateBooking(Long bookingId) {
        var oldBookingOptional = bookingRepository.findByBookingStatusAndId(BookingStatus.PENDING, bookingId);
        if(oldBookingOptional.isPresent()) {
            var oldBooking = oldBookingOptional.get();
            oldBooking.setBookingStatus(BookingStatus.COMPLETED);
            var updatedBooking = bookingRepository.save(oldBooking);
            return bookingMapper.asBookingResponse(updatedBooking);
        }
        throw new BusinessLogicException(HttpStatus.BAD_REQUEST, HttpStatus.NOT_FOUND.value(), "Booking not found");
    }
}
