package dev.waiyanhtet.facilitybookingtest.scheduler;

import dev.waiyanhtet.facilitybookingtest.config.properties.BookingExpireConfig;
import dev.waiyanhtet.facilitybookingtest.dto.BookingStatus;
import dev.waiyanhtet.facilitybookingtest.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingExpirationHandler {

    private final BookingRepository bookingRepository;
    private final BookingExpireConfig bookingExpireConfig;

    @Scheduled(fixedRateString = "#{@bookingExpireConfig.fixedRateInMs}")
    public void bookingExpirationHandler() {
        System.out.println("Started to check expired booking.");
        LocalDateTime twoHoursAgo = LocalDateTime.now().minusHours(bookingExpireConfig.getHour());
        var pendingList = bookingRepository.findAllByExpiredBooking(twoHoursAgo, BookingStatus.PENDING);

        if(pendingList.isEmpty()) {
            log.info("Expired booking not found.");
        }

        pendingList.forEach(booking -> {
            log.info("Before update bookingId: {} bookingStatus : {}", booking.getId(), booking.getBookingStatus());
            booking.setBookingStatus(BookingStatus.CANCELLED);
            var updatedBooking = bookingRepository.save(booking);
            log.info("After update bookingId: {} bookingStatus : {}", updatedBooking.getId(), updatedBooking.getBookingStatus());
        });
    }
}
