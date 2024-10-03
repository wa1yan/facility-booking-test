

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