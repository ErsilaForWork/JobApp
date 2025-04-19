package org.jobapp.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "Jobs")
@SequenceGenerator(
        name = "seq",
        sequenceName = "job_seq",
        allocationSize = 1
)
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int id;

    private String postVacance;
    private String postDescription;
    private Integer reqExperience;
    private String[] postTechStack;

    public String getPostVacance() {
        return postVacance;
    }

    public void setPostVacance(String postVacance) {
        this.postVacance = postVacance;
    }

    public int getId() {
        return id;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public Integer getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(Integer reqExperience) {
        this.reqExperience = reqExperience;
    }

    public String[] getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(String[] postTechStack) {
        this.postTechStack = postTechStack;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", postVacance='" + postVacance + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + Arrays.toString(postTechStack) +
                '}';
    }
}
