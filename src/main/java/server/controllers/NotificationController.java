package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.common.NotificationModel;
import server.services.NotificationService;

import java.util.List;

@RestController
@RequestMapping(path="api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(path = "{notificationId}")
    public ResponseEntity<NotificationModel> getNotification(@PathVariable("notificationId") Long notificationId) {
        return ResponseEntity.of(notificationService.getNotification(notificationId));
    }

    // POST, http://localhost:8080/api/notification, {"notificationType":"FOR_CUSTOMER", "flightId":"1L", "userId":"1L", "delayMinutes":"0", "flightStatus":"NORMAL", "message":""}
    @PostMapping
    public ResponseEntity<Void> createNotification(@RequestBody NotificationModel notificationModel) {
        notificationService.addNewNotification(notificationModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{notificationId}")
    public ResponseEntity<Void> updateNotification(@PathVariable("notificationId") Long notificationId,
                                           @RequestParam(required = false) String message) {
        notificationService.updateNotification(notificationId, message);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("notificationId") Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok().build();
    }

}
