package org.jobapp.service;

import org.jobapp.model.JobPost;
import org.jobapp.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    private final JobPostRepo jobPostRepo = new JobPostRepo();

    public void addPost(JobPost jobPost){
        jobPostRepo.addJobPost(jobPost);
    }

    public JobPost addPost( String  vacance, String descr, Integer exp, String[] stack){
        JobPost jobPost = new JobPost();

        jobPost.setPostVacance(vacance);
        jobPost.setPostDescription(descr);
        jobPost.setPostTechStack(stack);
        jobPost.setReqExperience(exp);

        jobPostRepo.addJobPost(jobPost);
        return jobPost;
    }

    public List<JobPost> getPosts(){
        return jobPostRepo.getAllPosts();
    }
}
