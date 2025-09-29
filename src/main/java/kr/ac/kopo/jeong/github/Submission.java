package kr.ac.kopo.jeong.github;

import java.time.LocalDateTime;

public class Submission {
    private String filename;
    private LocalDateTime submittedAt;

    public Submission(String filename) {
        this.filename = filename;
        this.submittedAt = LocalDateTime.now();
    }

    // getter, setter
    public String getFilename() {
        return filename;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}

