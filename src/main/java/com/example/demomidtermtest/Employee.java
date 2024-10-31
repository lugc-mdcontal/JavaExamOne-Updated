package com.example.demomidtermtest;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date hireDate;
    private String jobCode;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId < 0)
            throw new IllegalArgumentException("The employee ID cannot be negative!");

        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isBlank() || firstName.length() <= 1)
            throw new IllegalArgumentException("The first name is blank or too short!");

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isBlank() || lastName.length() <= 1)
            throw new IllegalArgumentException("The last name is blank or too short!");

        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}\\.\\d{3}\\.\\d{4}"))
            throw new IllegalArgumentException("The phone number is not in the correct format!");


        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if (hireDate.after(new Date()))
            throw new IllegalArgumentException("The hire date cannot be in the future!");

        this.hireDate = hireDate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        if (!jobCode.matches("[A-Z]+_[A-Z]+"))
            throw new IllegalArgumentException("The job code is not in the correct format!");

        this.jobCode = jobCode;
    }

    public Employee(int employeeId, String firstName, String lastName, String phoneNumber, Date hireDate, String jobCode) {
        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setHireDate(hireDate);
        setJobCode(jobCode);
    }
}
