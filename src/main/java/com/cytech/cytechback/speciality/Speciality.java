package com.cytech.cytechback.speciality;

import com.cytech.cytechback.student.Student;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "specialities")
@SequenceGenerator(name = "specs_id_seq", sequenceName = "specs_id_seq", allocationSize = 1)
public class Speciality {

    @Id
    @Column(name = "speciality_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specs_id_seq")
    private Long id;

    @OneToMany(mappedBy="speciality")
    private Set<Student> students;
}
