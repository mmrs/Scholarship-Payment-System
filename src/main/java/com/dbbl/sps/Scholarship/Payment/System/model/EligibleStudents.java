package com.dbbl.sps.Scholarship.Payment.System.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EligibleStudents {

    @Id
    private Integer id;
    private Integer studentId;

    @Override
    public String toString() {
        return "EligibleStudents{" +
                "id=" + id +
                ", studentId=" + studentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public EligibleStudents() {
    }

    public EligibleStudents(Integer id, Integer studentId) {
        this.id = id;
        this.studentId = studentId;
    }
}
