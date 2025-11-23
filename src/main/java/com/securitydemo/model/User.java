package com.securitydemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Represents a user in the system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    /**
     * The unique identifier for the user.
     */
    @Id
    private Integer id;
    /**
     * The username of the user.
     */
    private String userName;
    /**
     * The password of the user.
     */
    private String password;
    /**
     * The roles assigned to the user.
     */
    private ArrayList<String> roles;
}
