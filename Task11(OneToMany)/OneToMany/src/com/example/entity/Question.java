package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="question")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="question_name")
    private String questionName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="qid")
    private List<Answer> answerList;

    public Question(String questionName) {
        this.questionName = questionName;
    }
}
