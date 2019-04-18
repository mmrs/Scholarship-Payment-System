package com.dbbl.sps.Scholarship.Payment.System.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EligibileStudents {

    @Id
    private Integer id;
    private Integer student_id;

    @Override
    public String toString() {
        return "EligibileStudents{" +
                "id=" + id +
                ", student_id=" + student_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public EligibileStudents(Integer id, Integer student_id) {
        this.id = id;
        this.student_id = student_id;
    }
}
