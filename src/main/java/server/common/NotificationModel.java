package server.common;

import javax.persistence.*;

@Entity
@Table
public class NotificationModel {
    @Id
    @SequenceGenerator(
            name = "notification_sequence",
            sequenceName = "notification_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "notification_sequence"
    )
    private Long notificationId;
    private NotificationTypeEnum notificationType;
    private Long flightId;
    private Long userId;
    private int delayMinutes;
    private FlightStatusEnum flightStatus;
    private String message;


    public NotificationModel(){
    }

    public NotificationModel(Long notificationId, NotificationTypeEnum notificationType, Long flightId, Long userId, int delayMinutes, FlightStatusEnum flightStatus, String message) {
        this.notificationId = notificationId;
        this.notificationType = notificationType;
        this.flightId = flightId;
        this.delayMinutes = delayMinutes;
        this.flightStatus = flightStatus;
        this.message = message;
    }

    public NotificationModel(NotificationTypeEnum notificationType, Long flightId, Long userId, int delayMinutes, FlightStatusEnum flightStatus, String message) {
        this.notificationType = notificationType;
        this.flightId = flightId;
        this.delayMinutes = delayMinutes;
        this.flightStatus = flightStatus;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationTypeEnum getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeEnum notificationType) {
        this.notificationType = notificationType;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    public void setDelayMinutes(int delayMinutes) {
        this.delayMinutes = delayMinutes;
    }

    public FlightStatusEnum getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatusEnum flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "notificationId=" + notificationId +
                ", notificationType=" + notificationType +
                ", flightId=" + flightId +
                ", userId=" + userId +
                ", delayMinutes=" + delayMinutes +
                ", flightStatus=" + flightStatus +
                ", message='" + message + '\'' +
                '}';
    }
}