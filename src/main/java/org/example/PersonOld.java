package org.example;

import java.util.*;

public class PersonOld {
    private String name;

    public String getName() {
        return name;
    }

    public PersonOld(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOld personOld = (PersonOld) o;
        return Objects.equals(name, personOld.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends PersonOld {
    private String studyPlace;
    private int studyYears;

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears && Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studyPlace, studyYears);
    }
}

class Worker extends PersonOld {
    private String workPosition;
    private int experienceYears;

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears && Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPosition, experienceYears);
    }
}

