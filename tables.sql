create table route
(
    id               serial,
    departure_city   character varying(50) NOT NULL,
    destination_city character varying(50) NOT NULL,
    departure_time   time                  NOT NULL,
    arrival_time     time                  NOT NULL,
    duration         time                  NOT NULL,
    PRIMARY KEY (id)
);

insert into route (departure_city, destination_city, departure_time, arrival_time, duration)
values ('Vilnius', 'Kaunas', '14:20:00', '15:40:00', '1:20:00');
insert into route (departure_city, destination_city, departure_time, arrival_time, duration)
values ('Vilnius', 'Kaunas', '16:20:00', '17:40:00', '1:20:00');


-- Vilnius - Kaunas 13 20 - 14 40
-- Vilnius - Kaunas 16 20 - 17 40

create table train
(
    id     serial,
    name   character varying(50) NOT NULL,
    number character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into train (name, number)
VALUES ('Testy', '505');

create table trip
(
    id       serial,
    route_id integer not null,
    date     date    not null,
    train_id integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (train_id) REFERENCES train (id) ON DELETE CASCADE,
    FOREIGN KEY (route_id) REFERENCES route (id) ON DELETE CASCADE
);

insert into trip (route_id, date, train_id)
VALUES (1, '2023-11-20', 1);

insert into trip (route_id, date, train_id)
VALUES (2, '2023-11-20', 1);

insert into trip (route_id, date, train_id)
VALUES (1, '2023-12-20', 1);

insert into trip (route_id, date, train_id)
VALUES (2, '2023-12-20', 1);

create table train_seats
(
    id          serial,
    train_id    integer       not null,
    seats_count integer       not null,
    price       numeric(6, 2) not null,
    class       integer       not null,
    PRIMARY KEY (id),
    FOREIGN KEY (train_id) REFERENCES train (id) ON DELETE CASCADE
);

insert into train_seats (train_id, seats_count, price, class)
values (1, 20, 10.0, 1);

create table trip_seats
(
    id              serial,
    trip_id         integer not null,
    class           integer not null,
    available_seats integer not null,
    PRIMARY KEY (id),
    FOREIGN KEY (trip_id) REFERENCES trip (id) ON DELETE CASCADE
);

insert into trip_seats (trip_id, class, available_seats)
values (1, 1, 19);

create table train_user
(
    id       serial,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    name     character varying(50) NOT NULL,
    surname  character varying(50) NOT NULL,
    email    character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into train_user (username, password, name, surname, email)
values ('lan', 'lan', 'Joe', 'Madridov', 'lan@gmail.com');

create table ticket_booking
(
    id                 serial,
    user_id            integer,
    trip_id            integer               not null,
    name               character varying(50) NOT NULL,
    surname            character varying(50) NOT NULL,
    email              character varying(50) NOT NULL,
    seat_class         integer               not null,
    transaction_number character varying(50) NOT NULL,
    booking_time       timestamp             NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES train_user (id) ON DELETE CASCADE,
    FOREIGN KEY (trip_id) REFERENCES trip (id) ON DELETE CASCADE
);


insert into ticket_booking (user_id, trip_id, name, surname, email, seat_class, transaction_number, booking_time)
values (1, 1, '', '', '', 1, '12345', '2023-10-19 10:23:54');

insert into ticket_booking (user_id, trip_id, name, surname, email, seat_class, transaction_number, booking_time)
values (1, 1, '', '', '', 1, '12345', '2023-10-19 10:23:54');

insert into ticket_booking (user_id, trip_id, name, surname, email, seat_class, transaction_number, booking_time)
values (1, 3, '', '', '', 1, '12345', '2023-10-30 10:23:54');


SELECT * FROM trip t JOIN public.route r on r.id = t.route_id
         WHERE r.departure_city = 'Vilnius' AND r.destination_city = 'Kaunas' AND t.date = '2023-11-20'