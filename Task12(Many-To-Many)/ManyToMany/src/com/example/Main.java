package com.example;

import com.example.entity.Course;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        List<Student> studentList = new ArrayList<>();

        Collections.addAll(studentList,
                new Student("john123", "John", "Doe"),
                new Student("omar123", "Omar", "Mohamed")
        );

        List<Course> courseList = new ArrayList<>();

        Collections.addAll(courseList,
                new Course("Java"),
                new Course("Python")
        );
        try {
            session.beginTransaction();
            for (Course course : courseList) {
                course.setStudentList(studentList);
                session.save(course);
            }

            for (Student student : studentList) {
                student.setCourseList(courseList);
                session.save(student);
            }
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
