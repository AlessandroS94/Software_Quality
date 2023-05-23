package com.nnt.data.springbootrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "utente")
public class Utente extends BaseEntity {
    private String name;
    private String surname;
    @Column(columnDefinition = "DATE")
    private LocalDate data;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "gruppo_id")
    private Gruppo gruppo;

}