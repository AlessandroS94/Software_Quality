package com.nnt.data.springbootrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "gruppo")
public class Gruppo extends BaseEntity {
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "gruppo", orphanRemoval = true)
    private List<Utente> utentes = new ArrayList<>();

    public void addUtente(Utente utente) {
        this.utentes.add(utente);
        utente.setGruppo(this);
    }
}