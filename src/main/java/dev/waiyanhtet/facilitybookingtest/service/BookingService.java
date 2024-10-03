package dev.waiyanhtet.facilitybookingtest.service;

import dev.waiyanhtet.facilitybookingtest.dto.request.BookingRequest;
import dev.waiyanhtet.facilitybookingtest.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {

    BookingResponse createBooking(BookingRequest request);
    List<BookingResponse> retrieveBooking(Long customerId);
    BookingResponse updateBooking(Long bookingId);
}
