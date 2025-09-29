package kr.ac.kopo.jeong.github;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AssignmentController {

    private final SubmissionService submissionService;

    public AssignmentController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping("/submit")
    public String submitAssignment(@RequestParam("file") MultipartFile file) throws IOException {
        Path path = Paths.get("assignments/" + file.getOriginalFilename());
        Files.write(path, file.getBytes());

        submissionService.save(file.getOriginalFilename());

        ProcessBuilder pb = new ProcessBuilder("bash", "-c",
                "git add . && git commit -m '과제 제출: " + file.getOriginalFilename() + "' && git push");
        pb.directory(new File(System.getProperty("user.dir")));
        pb.start();

        return "redirect:/success";
    }

    @GetMapping("/admin")
    public String viewSubmissions(Model model) {
        model.addAttribute("submissions", submissionService.getAll());
        return "admin";
    }
}
