package dev.waiyanhtet.facilitybookingtest.repository;

import dev.waiyanhtet.facilitybookingtest.dto.BookingStatus;
import dev.waiyanhtet.facilitybookingtest.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b WHERE b.bookingTime < :twoHoursAgo AND b.bookingStatus = :bookingStatus")
    List<BookingEntity> findAllByExpiredBooking(LocalDateTime twoHoursAgo, BookingStatus bookingStatus);

    Optional<BookingEntity> findByBookingStatusAndId(BookingStatus bookingStatus, Long bookingId);

    List<BookingEntity> findByCustomerId(Long customerId);
}
