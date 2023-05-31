package com.nnt.data.springbootrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private List<User> users = new ArrayList<>();


    public void addUtente(User user) {
        this.users.add(user);
        user.setGroup(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }
}