package com.cytech.cytechback.user;

import com.cytech.cytechback.orientation.Orientation;
import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.speciality.Speciality;

import java.util.Date;

public class UserDTO implements SimpleDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private Date birthdayDate;

    private String emailAddress;

    private String address;

    private String status;

    private Speciality speciality;

    private int hoursAbsent;

    private Orientation orientation;

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getHoursAbsent() {
        return hoursAbsent;
    }

    public void setHoursAbsent(int hoursAbsent) {
        this.hoursAbsent = hoursAbsent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
