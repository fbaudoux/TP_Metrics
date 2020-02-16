package com.systel.dojoservice.domain.kata;

import com.systel.dojoservice.domain.kata.entity.Membership;
import com.systel.dojoservice.domain.kata.entity.TeamEntity;
import com.systel.dojoservice.domain.kata.entity.TeammateEntity;
import com.systel.dojoservice.domain.kata.repository.MembershipRepository;
import com.systel.dojoservice.domain.kata.repository.TeamRepository;
import com.systel.dojoservice.domain.kata.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KatateamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeammateRepository teammateRepository;

    @Autowired
    MembershipRepository membershipRepository;

    public TeamEntity createTeam(String name) {
        TeamEntity newTeam = new TeamEntity();
        newTeam.setName(name);
        teamRepository.save(newTeam);
        return newTeam;
    }

    public TeammateEntity createTeammate(String name) {
        TeammateEntity newTeammate = new TeammateEntity();
        newTeammate.setName(name);
        teammateRepository.save(newTeammate);
        return newTeammate;
    }

    public Membership addTeammateToTeam(Long teammateId, Long teamId) {
        TeamEntity teamEntity = teamRepository.findById(teamId).get();
        TeammateEntity teammateEntity = teammateRepository.findById(teammateId).get();
        Membership membership = new Membership();
        membership.setTeamId(teamEntity.getId());
        membership.setTeammateId(teammateEntity.getId());
        return membershipRepository.save(membership);
    }
}
