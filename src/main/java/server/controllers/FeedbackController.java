package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.common.FeedbackModel;
import server.services.FeedbackService;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping(path = "{feedbackId}")
    public ResponseEntity<Optional<FeedbackModel>> getFeedbackModel(Long feedbackId) {
        return ResponseEntity.ok(feedbackService.getFeedback(feedbackId));
    }

    @PostMapping()
    public ResponseEntity<Void> createFeedbackModel(@RequestBody FeedbackModel feedbackModel) {
        feedbackService.addNewFeedback(feedbackModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{feedbackId}")
    public ResponseEntity<Void> updateFeedback(
            @PathVariable("feedbackId") Long feedbackId,
            @RequestParam(required = false) String opinion) {
        feedbackService.updateFeedback(feedbackId, opinion);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{feedbackId}")
    public ResponseEntity<Void> deleteFeedbackModel(@PathVariable("feedbackId") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.ok().build();
    }
}
