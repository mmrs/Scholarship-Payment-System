package com.dbbl.sps.Scholarship.Payment.System.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Entity
public class Students {

    @Id
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String gender;
    private String village;
    private String road;
    private String postOffice;
    private String thana;
    private String district;
    private String phone;
    private String sscRoll;
    private String sscGpaWithFourthSubject;
    private String sscGpaWithoutFourthSubject;
    private String sscExamYear;
    private String sscStudyGroup;
    private String sscInstitutionName;

    public String getSscInstitutionName() {
        return sscInstitutionName;
    }

    public void setSscInstitutionName(String sscInstitutionName) {
        this.sscInstitutionName = sscInstitutionName;
    }

    public String getSscBoard() {
        return sscBoard;
    }

    public void setSscBoard(String sscBoard) {
        this.sscBoard = sscBoard;
    }

    public String getHscInstitutionName() {
        return hscInstitutionName;
    }

    public void setHscInstitutionName(String hscInstitutionName) {
        this.hscInstitutionName = hscInstitutionName;
    }

    public String getHscBoard() {
        return hscBoard;
    }

    public void setHscBoard(String hscBoard) {
        this.hscBoard = hscBoard;
    }

    private String sscBoard;
    private String hscRoll;
    private String hscGpaWithFourthSubject;
    private String hscGpaWithoutFourthSubject;
    private String hscExamYear;
    private String hscStudyGroup;
    private String hscInstitutionName;
    private String hscBoard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSscRoll() {
        return sscRoll;
    }

    public void setSscRoll(String sscRoll) {
        this.sscRoll = sscRoll;
    }

    public String getSscGpaWithFourthSubject() {
        return sscGpaWithFourthSubject;
    }

    public void setSscGpaWithFourthSubject(String sscGpaWithFourthSubject) {
        this.sscGpaWithFourthSubject = sscGpaWithFourthSubject;
    }

    public String getSscGpaWithoutFourthSubject() {
        return sscGpaWithoutFourthSubject;
    }

    public void setSscGpaWithoutFourthSubject(String sscGpaWithoutFourthSubject) {
        this.sscGpaWithoutFourthSubject = sscGpaWithoutFourthSubject;
    }

    public String getSscExamYear() {
        return sscExamYear;
    }

    public void setSscExamYear(String sscExamYear) {
        this.sscExamYear = sscExamYear;
    }

    public String getSscStudyGroup() {
        return sscStudyGroup;
    }

    public void setSscStudyGroup(String sscStudyGroup) {
        this.sscStudyGroup = sscStudyGroup;
    }

    public String getHscRoll() {
        return hscRoll;
    }

    public void setHscRoll(String hscRoll) {
        this.hscRoll = hscRoll;
    }

    public String getHscGpaWithFourthSubject() {
        return hscGpaWithFourthSubject;
    }

    public void setHscGpaWithFourthSubject(String hscGpaWithFourthSubject) {
        this.hscGpaWithFourthSubject = hscGpaWithFourthSubject;
    }

    public String getHscGpaWithoutFourthSubject() {
        return hscGpaWithoutFourthSubject;
    }

    public void setHscGpaWithoutFourthSubject(String hscGpaWithoutFourthSubject) {
        this.hscGpaWithoutFourthSubject = hscGpaWithoutFourthSubject;
    }

    public String getHscExamYear() {
        return hscExamYear;
    }

    public void setHscExamYear(String hscExamYear) {
        this.hscExamYear = hscExamYear;
    }

    public String getHscStudyGroup() {
        return hscStudyGroup;
    }

    public void setHscStudyGroup(String hscStudyGroup) {
        this.hscStudyGroup = hscStudyGroup;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", gender='" + gender + '\'' +
                ", village='" + village + '\'' +
                ", road='" + road + '\'' +
                ", postOffice='" + postOffice + '\'' +
                ", thana='" + thana + '\'' +
                ", district='" + district + '\'' +
                ", phone='" + phone + '\'' +
                ", sscRoll='" + sscRoll + '\'' +
                ", sscGpaWithFourthSubject='" + sscGpaWithFourthSubject + '\'' +
                ", sscGpaWithoutFourthSubject='" + sscGpaWithoutFourthSubject + '\'' +
                ", sscExamYear='" + sscExamYear + '\'' +
                ", sscStudyGroup='" + sscStudyGroup + '\'' +
                ", sscInstitutionName='" + sscInstitutionName + '\'' +
                ", sscBoard='" + sscBoard + '\'' +
                ", hscRoll='" + hscRoll + '\'' +
                ", hscGpaWithFourthSubject='" + hscGpaWithFourthSubject + '\'' +
                ", hscGpaWithoutFourthSubject='" + hscGpaWithoutFourthSubject + '\'' +
                ", hscExamYear='" + hscExamYear + '\'' +
                ", hscStudyGroup='" + hscStudyGroup + '\'' +
                ", hscInstitutionName='" + hscInstitutionName + '\'' +
                ", hscBoard='" + hscBoard + '\'' +
                '}';
    }
}
