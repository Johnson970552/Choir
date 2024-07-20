package com.ac.choir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac.choir.Entity.ChoirEntity;
@Repository
public interface ChoirRepository extends JpaRepository<ChoirEntity, Long> {

}
