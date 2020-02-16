package com.systel.dojoservice.domain.kata.repository;

import com.systel.dojoservice.domain.kata.entity.TeammateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeammateRepository extends JpaRepository<TeammateEntity, Long> {
}
