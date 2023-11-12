create table train_route
(
    id               serial,
    departure_city   character varying(50) NOT NULL,
    destination_city character varying(50) NOT NULL,
    departure_time   time                  NOT NULL,
    arrival_time     time                  NOT NULL,
    duration         time                  NOT NULL,
    PRIMARY KEY (id)
);

create table train
(
    id     serial,
    name   character varying(50) NOT NULL,
    number character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

create table ticket
(
    id          serial,
    route_id    integer NOT NULL,
    date        date    NOT NULL,
    class       integer,
    seat_number integer,
    train_id    integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (route_id) REFERENCES train_route (id) ON DELETE CASCADE,
    FOREIGN KEY (train_id) REFERENCES train (id) ON DELETE CASCADE
);

create table train_user
(
    id      serial,
    name    character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    email   character varying(50) NOT NULL,
    number  character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

create table ticket_booking
(
    id                 serial,
    user_id            integer,
    name               character varying(50) NOT NULL,
    surname            character varying(50) NOT NULL,
    email              character varying(50) NOT NULL,
    number             character varying(50) NOT NULL,
    transaction_number character varying(50) NOT NULL,
    booking_time       timestamp             NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES train_user (id) ON DELETE CASCADE
);