package com.systel.dojoservice.domain.kata.repository;

import com.systel.dojoservice.domain.kata.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {


    public List<Membership> findAllByTeamId(Long teamId);
}
