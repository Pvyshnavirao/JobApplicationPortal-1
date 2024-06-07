package com.example.Job.service;

import com.example.Job.model.JobPost;
import com.example.Job.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

@Autowired
private JobRepo Jobrepo;

    public void addJob(JobPost jobPost){
          Jobrepo.addJobPost(jobPost);
    }
     public List<JobPost> returnAllJobPosts(){
        return Jobrepo.returnAllJobPosts();

     }
}
