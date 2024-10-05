package com.luve2code.springdemo.mvc.model;

import com.luve2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;


    @NotNull(message = "is required")
    @Min(value= 0, message="must be greater than or equal to zero")
    @Max(value= 10, message="must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}",message = " postal code must be 5 chars long")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String courseCode;

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

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
