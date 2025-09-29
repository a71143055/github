package kr.ac.kopo.jeong.github;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionService {

    private final List<Submission> submissions = new ArrayList<>();

    public void save(String filename) {
        submissions.add(new Submission(filename, LocalDateTime.now()));
    }

    public List<Submission> getAll() {
        return submissions;
    }
}
