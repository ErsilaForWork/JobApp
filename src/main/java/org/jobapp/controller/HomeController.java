package org.jobapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jobapp.model.JobPost;
import org.jobapp.service.JobPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping({"/","home"})
    public String home(){
        return "home";
    }

    @RequestMapping("/addjob")
    public String addJobs(){
        return "addjob";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/viewalljobs")
    public ModelAndView allJobs(ModelAndView mv, JobPostService service){
        List<JobPost> jobPosts = service.getPosts();
        mv.addObject("jobPosts", jobPosts);
        mv.setViewName("viewalljobs");
        return mv;
    }

    @RequestMapping("/success")
    public String successPage(@RequestParam("postProfile") String  vacance, @RequestParam("postVacance") String descr, @RequestParam("reqExperience") Integer exp, @RequestParam("postTechStack") String[] stack, HttpServletRequest request, JobPostService service){
        JobPost jobPost = service.addPost(vacance,descr,exp,stack);

        request.setAttribute("jobPost", jobPost);
        return "success";
    }
}
