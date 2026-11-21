package com.bezy.school_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "members")
    private int members;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Teacher> teachers =  new ArrayList<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Subject> subjects = new LinkedHashSet<>();

    public Department(Long id,
                      String name,
                      int members,
                      List<Teacher> teachers,
                      Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.teachers = teachers;
        this.subjects = subjects;
    }

    public Department() {
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.setDepartment(this);
        this.members = teachers.size();
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.setDepartment(null);
        this.members = teachers.size();
    }


}