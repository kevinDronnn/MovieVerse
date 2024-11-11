package org.example.movietickets.dto;

import java.sql.Timestamp;

/**
 * Dto for SeatReservation
 *
 * @author Artem Voroshylin
 * @version 1.0
 * @since 1.5
 */
public class SeatReservationDto {
    private int id;
    private int movieScheduleId;
    private int seatRow;
    private int seatNumber;
    private boolean reserved;
    private Timestamp reservationTime;

    public SeatReservationDto() {
    }

    public SeatReservationDto(int id, int movieScheduleId, int seatRow, int seatNumber, boolean reserved, Timestamp reservationTime) {
        this.id = id;
        this.movieScheduleId = movieScheduleId;
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

    public int getMovieScheduleId() {
        return movieScheduleId;
    }

    public void setMovieScheduleId(int movieScheduleId) {
        this.movieScheduleId = movieScheduleId;
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
        return "SeatReservationDto{" +
                "id=" + id +
                ", movieScheduleId=" + movieScheduleId +
                ", seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                ", reserved=" + reserved +
                ", reservationTime=" + reservationTime +
                '}';
    }
}
