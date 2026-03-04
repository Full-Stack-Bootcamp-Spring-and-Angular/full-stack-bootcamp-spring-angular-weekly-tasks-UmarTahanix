package com.example;

import com.example.entity.Course;
import com.example.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Instructor instructor = new Instructor("Ahmad Salah");

        List<Course> courses = new ArrayList<>();

        Collections.addAll(courses,
                new Course("Java Basics"),
                new Course("Spring Core"),
                new Course("MVC")
        );

        instructor.setCourseList(courses);

        try{
            session.beginTransaction();
            for(Course course : courses){
                course.setInstructor(instructor);
                session.save(course);
            }
            session.save(instructor);
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
