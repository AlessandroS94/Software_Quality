package com.nnt.data.springbootrest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    private String surname;
    @Column(columnDefinition = "DATE")
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "groups_id")
    private Group group;

}