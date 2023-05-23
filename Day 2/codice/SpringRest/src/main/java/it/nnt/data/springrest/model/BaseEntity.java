package it.nnt.data.springrest.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}