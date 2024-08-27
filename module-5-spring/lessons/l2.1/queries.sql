create database hotel;
use hotel;

create table reservations(
    reservations_id int auto_increment primary key,
    guest_name varchar(255) not null,
    room_number int not null,
    contact_number varchar(10) not null,
    reservation_date timestamp default current_timestamp
);
