package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private final IReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }


    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String rId) {
        return reservationService.retrieveReservation(rId);
    }


    @GetMapping("/retrieve-reservation-date-status/{d}/{v}")
    public List<Reservation> retrieveReservationParDateEtStatus(
            @PathVariable("d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d,
            @PathVariable("v") boolean b) {
        return reservationService.trouverResSelonDateEtStatus(d, b);
    }

    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }


    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String rId) {
        reservationService.removeReservation(rId);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return reservationService.modifyReservation(r);
    }
}
