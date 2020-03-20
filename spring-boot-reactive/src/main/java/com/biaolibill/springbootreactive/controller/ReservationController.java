package com.biaolibill.springbootreactive.controller;

import com.biaolibill.springbootreactive.model.Reservation;
import com.biaolibill.springbootreactive.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Room reservation controller
 */

@RestController
@RequestMapping(ReservationController.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationController {

    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

    private final ReservationServiceImpl reservationServiceImpl;

    @Autowired
    public ReservationController(ReservationServiceImpl reservationServiceImpl) {
        this.reservationServiceImpl = reservationServiceImpl;
    }

    @GetMapping(path = "{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String roomId) {

        //reservationService.getReservation(roomId);

        return reservationServiceImpl.getReservation(roomId);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation) {

        return reservationServiceImpl.createReservation(reservation);
    }


    @PutMapping(path = "{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> updatePrice(@PathVariable String roomId,
                                    @RequestBody Mono<Reservation> reservation) {

        return Mono.just("{}");
    }

    @DeleteMapping(path = "{roomId}")
    public Mono<Boolean> deleteReservation(@PathVariable String roomId) {

        return Mono.just(true);
    }
}
