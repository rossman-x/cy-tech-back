package com.cytech.cytechback.student;

import com.cytech.cytechback.speciality.Speciality;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "students")
@SequenceGenerator(name = "students_id_seq", sequenceName = "students_id_seq", allocationSize = 1)
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_id_seq")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthdayDate;

    @Column(name = "email_address", length = 50, nullable = false)
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable=false)
    private Speciality speciality;


}
