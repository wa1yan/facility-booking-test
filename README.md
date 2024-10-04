# Sample Facility Booking Service

### Technical Usage
    - Used Mapstruct for object mapping
    - Used Global JsonDeserializer and JsonSerializer for LocalDateTime
    - Used Global Exception Handler
    - Used Scheduler for facility booking expired

### Project Setup
    - Add database config in application.yaml
    - Run the project eg. mvn spring-boot:run
    - Insert initial query for customer and facility

### Initial Query
````
SET FOREIGN_KEY_CHECKS = 0;
truncate table customer;
truncate table facility;
truncate table booking;
truncate table booking_facility;
SET FOREIGN_KEY_CHECKS = 1;

insert into customer values (1, 'waiyan', 'waiyan@gmail.com');
insert into customer values (2, 'niko', 'niko@gmail.com');

insert into facility values (1, 'facility one description', 'facility one');
insert into facility values (2, 'facility two description', 'facility two');
insert into facility values (3, 'facility three description', 'facility three');
````

### Configuration Changes
We can adjust for expiration time in our configuration (application.yaml)
````
        booking-expire:
            hour: 2  #adjust value for testing
            fixedRateInMs: 50000 #adjust value for testing
````
In this configuration, booking will expire after 2 hour later. And scheduler will check expired booking every 50000 ms. If booking expired, booking status will change CANCELLED.


### API Testing

##### Get All Facility
````
curl --location 'http://localhost:8083/facilities'
````

##### Get All Booking By Customer Id
````
curl --location 'http://localhost:8083/bookings/1'
````

##### Facility Booking
````
curl --location 'http://localhost:8083/booking' \
--data '{
    "facilityIds" : [1,2],
    "customerId" : 1
}'
````

##### Update Booking Status By Booking Id
````
curl --location --request PUT 'http://localhost:8083/booking/2'
````
