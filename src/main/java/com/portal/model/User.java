package com.portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="users_sequence")
    @SequenceGenerator(name = "users_sequence" , sequenceName =  "users_sequence", initialValue = 0,allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your name")
    private String lastName;

    @Column(name = "gender")
    @NotEmpty(message = "*Please provide your last name")
    private String gender;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide your last name")
    private String address;

    @Column(name = "active")
    private Boolean active;



    @Column(name = "Last_Login_time")
    private Timestamp lastLoginTime;

/*
    @Column(name = "facility")
    @NotEmpty(message = "*Please provide your last name")
    private String facility;*/



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")

    private  Role roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facility_id", referencedColumnName = "facility_id")
    private Facilities facility;


}
