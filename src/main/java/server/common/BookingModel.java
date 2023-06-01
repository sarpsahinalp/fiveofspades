package server.common;

import javax.persistence.*;

@Entity
@Table
public class BookingModel {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    private Long bookingId;
    private Long flightId;
    private String seat;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;
    private Long journeyId;
    private boolean isRated;

    public BookingModel() {
        this.isRated = false;
    }

    public BookingModel(Long flightId, String seat, UserModel userModel) {
        this.flightId = flightId;
        this.seat = seat;
        this.userModel = userModel;
        this.journeyId = -1L;
        this.isRated = false;
    }

    public BookingModel(Long flightId, String seat, UserModel userModel, Long journeyId) {
        this.flightId = flightId;
        this.seat = seat;
        this.userModel = userModel;
        this.journeyId = journeyId;
        this.isRated = false;
    }

    public BookingModel(Long bookingId, Long flightId, String seat, UserModel userModel, Long journeyId) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.seat = seat;
        this.userModel = userModel;
        this.journeyId = journeyId;
        this.isRated = false;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public UserModel getUserModel() {
        return this.userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public Long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Long journeyId) {
        this.journeyId = journeyId;
    }

    public boolean isRated() {
        return isRated;
    }

    public void setRated(boolean rated) {
        isRated = rated;
    }
}
