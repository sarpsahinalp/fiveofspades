package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.common.FlightModel;
import server.common.NotificationModel;
import server.repositories.NotificationRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final FlightService flightService;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, FlightService flightService) {
        this.notificationRepository = notificationRepository;
        this.flightService = flightService;
    }

    public Optional<NotificationModel> getNotification(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public List<NotificationModel> getNotifications() {
        return notificationRepository.findAll();
    }

    public void addNewNotification(NotificationModel notification) {
        notification.setMessage(generateMessage(notification));
        notificationRepository.save(notification);
    }

    public void deleteNotification(Long notificationId) {
        if (! notificationRepository.existsById(notificationId)) {
            throw new IllegalStateException("notification does not exist");
        }
        notificationRepository.deleteById(notificationId);
    }

    @Transactional
    public void updateNotification(Long notificationId, String message) {
        NotificationModel notification = notificationRepository.findById(notificationId)
                .orElseThrow(()->new IllegalStateException("notification does not exist"));
        if (message != null && message.length() > 0 && !Objects.equals(notification.getMessage(), message)) {
            notification.setMessage(message);
        }
    }

    public String generateMessage(NotificationModel notification) {

        Optional<FlightModel> flightOptional = flightService.getFlight(notification.getFlightId());
        if (flightOptional.isEmpty()) {
            throw new IllegalStateException("flight does not exist");
        }
        FlightModel flight = flightOptional.get();

        String message = "";
        switch (notification.getNotificationType()) {
            case FOR_CUSTOMER -> {
                message = "Your flight from " + flight.getFromAirport() + " to " + flight.getToAirport() + " ";
                message += switch (notification.getFlightStatus()) {
                    case NORMAL -> "will be right on time. ";
                    case DELAYED -> "will be " + notification.getDelayMinutes() + " minutes late. We apologize for any inconveniences caused.";
                    case CANCELED -> "has been canceled. We apologize for any inconveniences caused.";
                };
            }
            // TODO: implement join table for flightId, userId, seat -> take userId as input, get seat instead of id
            case FOR_STAFF -> message = "Customer " + notification.getUserId() + " requested service. ";
        };

        return message;
    }
}
