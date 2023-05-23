package it.nnt.data.springrest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
public class Student extends BaseEntity {
    private String name;
    private String surname;
    @Column(columnDefinition = "DATE")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

}