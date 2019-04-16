package com.dbbl.sps.Scholarship.Payment.System.model;

public class RegisterUser {

    private Users users;
    private Students students;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public RegisterUser() {
        this.users = new Users();
        this.students = new Students();
    }
}
