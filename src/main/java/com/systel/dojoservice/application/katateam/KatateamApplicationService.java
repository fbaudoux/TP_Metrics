package com.systel.dojoservice.application.katateam;

import com.systel.dojoservice.application.katateam.command.AddTeammateToTeamRequest;
import com.systel.dojoservice.application.katateam.command.AddTeammateToTeamResponse;
import com.systel.dojoservice.application.katateam.command.CreateTeamRequest;
import com.systel.dojoservice.application.katateam.command.CreateTeamResponse;
import com.systel.dojoservice.application.katateam.command.CreateTeammateRequest;
import com.systel.dojoservice.application.katateam.command.CreateTeammateResponse;
import com.systel.dojoservice.application.katateam.command.GetAllTeammatesResponse;
import com.systel.dojoservice.application.katateam.command.GetAllTeamsResponse;
import com.systel.dojoservice.application.katateam.command.GetTeamRequest;
import com.systel.dojoservice.application.katateam.command.GetTeamResponse;
import com.systel.dojoservice.domain.kata.KatateamService;
import com.systel.dojoservice.domain.kata.entity.Membership;
import com.systel.dojoservice.domain.kata.entity.TeamEntity;
import com.systel.dojoservice.domain.kata.entity.TeammateEntity;
import com.systel.dojoservice.domain.kata.repository.MembershipRepository;
import com.systel.dojoservice.domain.kata.repository.TeamRepository;
import com.systel.dojoservice.domain.kata.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class KatateamApplicationService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeammateRepository teammateRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    KatateamService katateamService;

    public GetAllTeamsResponse getAllTeams() {
        return new GetAllTeamsResponse(teamRepository.findAll());
    }

    public GetTeamResponse getTeam(GetTeamRequest req) {

        TeamEntity aTeam = teamRepository.findById(req.getTeamId()).get();

        List<Membership> l = membershipRepository.findAllByTeamId(aTeam.getId());

        //Grosse erreur avec un n + 1 select , fait expres
        List<TeammateEntity> members = l.stream().map(membership -> teammateRepository.findById(membership.getTeammateId()).get()).collect(Collectors.toList());

        return new GetTeamResponse(aTeam, members);
    }

    public CreateTeamResponse createTeam(CreateTeamRequest req) {
        return new CreateTeamResponse(katateamService.createTeam(req.getName()));

    }

    public GetAllTeammatesResponse getAllTeammates() {
        return new GetAllTeammatesResponse(teammateRepository.findAll());
    }

    public CreateTeammateResponse createTeammate(CreateTeammateRequest req) {
        return new CreateTeammateResponse(katateamService.createTeammate(req.getName()));

    }

    public AddTeammateToTeamResponse addTeammateToTeam(AddTeammateToTeamRequest req) {
        return new AddTeammateToTeamResponse(katateamService.addTeammateToTeam(req.getTeammateId(), req.getTeamId()));
    }

}
