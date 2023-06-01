package server.common;

import javax.persistence.*;

@Entity
@Table
public class FeedbackModel {

    @Id
    @SequenceGenerator(
            name = "feedback_sequence",
            sequenceName = "feedback_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "feedback_sequence"
    )

    private Long feedbackId;
    private String opinion;

    public FeedbackModel() {
    }

    public FeedbackModel(Long feedbackId, String opinion) {
        this.feedbackId = feedbackId;
        this.opinion = opinion;
    }

    public FeedbackModel(String opinion) {
        this.opinion = opinion;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
