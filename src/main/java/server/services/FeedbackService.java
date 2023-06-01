package server.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.common.FeedbackModel;
import server.repositories.FeedbackRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Optional<FeedbackModel> getFeedback(Long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    public void addNewFeedback(FeedbackModel feedback) {
        Optional<FeedbackModel> feedbackOptional =  feedbackRepository.findById(feedback.getFeedbackId());
        if (feedbackOptional.isPresent()) {
            throw new IllegalStateException("flight already exists");
        }
        feedbackRepository.save(feedback);
    }

    @Transactional
    public void updateFeedback(Long feedbackId,
                             String opinion) {
        FeedbackModel feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new IllegalStateException("flight does not exist"));

        if (opinion != null && opinion.length() > 0 && !Objects.equals(feedback.getOpinion(), opinion)) {
            feedback.setOpinion(opinion);
        }
    }

    public void deleteFeedback(Long feedbackId) {
        if (!feedbackRepository.existsById(feedbackId)) {
            throw new IllegalStateException("flight does not exist");
        }
        feedbackRepository.deleteById(feedbackId);
    }
}
