package it.nnt.data.springrest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "corso")
public class Corso extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "corso", orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

}