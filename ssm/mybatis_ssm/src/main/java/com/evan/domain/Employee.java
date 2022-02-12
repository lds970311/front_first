
package com.evan.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = -649998812354667710L;
    private Integer id;
    private String lastName;
    private String gender;
    private String email;

    public Employee(Integer id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employee() {
    }
}
