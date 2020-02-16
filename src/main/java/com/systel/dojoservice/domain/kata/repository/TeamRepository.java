package com.systel.dojoservice.domain.kata.repository;

import com.systel.dojoservice.domain.kata.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

}
