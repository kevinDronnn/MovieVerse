package org.example.movietickets.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "seat_reservation")
public class SeatReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_screening_schedule_id", nullable = false)
    private MovieSchedule movieSchedule;

    @Column(name = "seat_row", nullable = false)
    private int seatRow;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    @Column(name = "reserved", nullable = false)
    private boolean reserved;

    @Column(name = "reservation_time", nullable = false)
    private Timestamp reservationTime;

    public SeatReservation() {
    }

    public SeatReservation(MovieSchedule movieSchedule, int seatRow, int seatNumber, boolean reserved, Timestamp reservationTime) {
        this.movieSchedule = movieSchedule;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.reserved = reserved;
        this.reservationTime = reservationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    @Override
    public String toString() {
        return "SeatReservation{" +
                "id=" + id +
                ", movieSchedule=" + movieSchedule +
                ", seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                ", reserved=" + reserved +
                ", reservationTime=" + reservationTime +
                '}';
    }
}
