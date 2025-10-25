package com.bezy.school_system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "post_pone")
    @Enumerated(EnumType.STRING)
    private PostPone postpone;

    @Column(name = "decision")
    @Enumerated(EnumType.STRING)
    private Decision decision;

    @OneToMany(mappedBy = "exam")
    private Set<Result> results = new LinkedHashSet<>();

    public Exam(Long id,
                Subject subject,
                LocalDate examDate,
                Decision decision,
                PostPone postpone,
                String subjectName,
                LocalTime startTime,
                LocalTime endTime,
                Set<Result> results) {
        this.id = id;
        this.subject = subject;
        this.examDate = examDate;
        this.decision = decision;
        this.postpone = postpone;
        this.subjectName = subjectName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.results = results;
    }

    public Exam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public PostPone getPostpone() {
        return postpone;
    }
    public void setPostpone(PostPone postpone) {
        this.postpone = postpone;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}