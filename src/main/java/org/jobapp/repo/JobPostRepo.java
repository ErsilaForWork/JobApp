package org.jobapp.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jobapp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobPostRepo {
    private static final SessionFactory sf = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(JobPost.class)
                                        .buildSessionFactory();

    public void addJobPost(JobPost jobPost){

        try(Session session = sf.openSession()){
            Transaction ts = session.beginTransaction();
            session.persist(jobPost);
            ts.commit();
        } catch (Exception e) {
            System.out.println("Wrong in addJobPost method!");
        }

    }

    public List<JobPost> getAllPosts(){

        try(Session session = sf.openSession()){
            String HQL = "from JobPost";
            return session.createQuery(HQL, JobPost.class).getResultList();
        } catch (Exception e){
            System.out.println("Wrong in getAllPosts method!");
            return null;
        }

    }
}
