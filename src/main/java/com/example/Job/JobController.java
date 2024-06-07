package com.example.Job;

import com.example.Job.model.JobPost;
import com.example.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @RequestMapping("/home")
    public String  home() {
        return "HomePage";
    }
    @RequestMapping("/addjob")
    public String  addJob() {

        return "addjob";
    }
    // controller method for getting all job posts
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

    // ************************************************************************

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJob(jobPost);
        //System.out.println(jobPost);
        return "success";

    }

}
