package com.nnt.data.springbootrest.repository;

import com.nnt.data.springbootrest.model.Gruppo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppoRepository extends JpaRepository<Gruppo, Long> {
}