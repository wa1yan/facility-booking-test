package dev.waiyanhtet.facilitybookingtest.entity;

import dev.waiyanhtet.facilitybookingtest.dto.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "booking_facility",
            joinColumns = @JoinColumn(name= "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "facility_id")
    )
    private List<FacilityEntity> facilities = new ArrayList<>();

}
