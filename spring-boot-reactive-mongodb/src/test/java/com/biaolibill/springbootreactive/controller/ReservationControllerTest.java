package com.biaolibill.springbootreactive.controller;

import com.biaolibill.springbootreactive.model.Reservation;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.biaolibill.springbootreactive.controller.ReservationController.ROOM_V_1_RESERVATION;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationControllerTest {

    @Autowired
    private ApplicationContext context;
    private WebTestClient webTestClient;
    private Reservation reservation;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient
                .bindToApplicationContext(this.context)
                .build();

        reservation = new Reservation(
                123l,
                LocalDate.now(),
                LocalDate.now().plus(10, ChronoUnit.DAYS),
                150 );
    }

    @Test
    void createReservation() {
        webTestClient.post()
                .uri(ROOM_V_1_RESERVATION)
                .body(Mono.just(reservation), Reservation.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.roomNumber").isEqualTo(reservation.getRoomNumber())
                //TODO check equal of the checkIN and checkOut
//                .jsonPath("$.checkIn").isEqualTo(reservation.getCheckIn())
                .jsonPath("$.price").isEqualTo(reservation.getPrice());
    }
}