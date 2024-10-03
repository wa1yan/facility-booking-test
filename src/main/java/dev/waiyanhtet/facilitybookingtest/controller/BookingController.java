package dev.waiyanhtet.facilitybookingtest.controller;

import dev.waiyanhtet.facilitybookingtest.dto.request.BookingRequest;
import dev.waiyanhtet.facilitybookingtest.dto.response.BookingResponse;
import dev.waiyanhtet.facilitybookingtest.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        return new ResponseEntity<>(bookingService.createBooking(bookingRequest), HttpStatus.OK);
    }

    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<BookingResponse> updateBooking(@PathVariable Long bookingId) {
        return new ResponseEntity<>(bookingService.updateBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/bookings/{customerId}")
    public ResponseEntity<List<BookingResponse>> retrieveBooking(@PathVariable Long customerId) {
        return new ResponseEntity<>(bookingService.retrieveBooking(customerId), HttpStatus.OK);
    }

}
