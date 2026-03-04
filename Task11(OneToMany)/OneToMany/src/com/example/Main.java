package com.example;

import com.example.entity.Answer;
import com.example.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Question question = new Question("First question");

        List<Answer> answers = new ArrayList<>();

        Collections.addAll(answers,
                new Answer("Solution 1"),
                new Answer("Solution 2")
        );

        question.setAnswerList(answers);

        try{
            session.beginTransaction();
            for(Answer answer : answers){
                session.save(answer);
            }
            session.save(question);
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
