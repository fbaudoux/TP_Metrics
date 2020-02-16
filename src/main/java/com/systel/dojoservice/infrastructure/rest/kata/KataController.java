package com.systel.dojoservice.infrastructure.rest.kata;

import com.systel.dojoservice.application.katateam.KatateamApplicationService;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller katateam.
 */
@RestController
@Api(value = "Teams", description = "Teams endpoints", tags = {"Teams"})
public class KataController {

    @Autowired
    KatateamApplicationService applicationService;

    @ApiOperation(value = "getAllTeams", notes = "Get all teams without any details about membership")
    @GetMapping( {"/teams/"})
    public GetAllTeamsResponse getAllTeams() {
        return applicationService.getAllTeams();
    }

    @ApiOperation(value = "getTeam", notes = "Get a team with its teammates")
    @GetMapping( {"/teams/{teamId}/"})
    public GetTeamResponse getTeam(@PathVariable(value = "teamId") Long teamId) {
        return applicationService.getTeam(new GetTeamRequest(teamId));
    }

    @ApiOperation(value = "getAllTeammates", notes = "Get all teammates")
    @GetMapping( {"/teammates/"})
    public GetAllTeammatesResponse getAllTeammates() {
        return applicationService.getAllTeammates();
    }

    @ApiOperation(value = "createTeammate", notes = "Create a new teammates with a name given in parameter")
    @PostMapping( {"/teammates/"})
    public CreateTeammateResponse createTeammate(@Valid @RequestBody String name) {
        return applicationService.createTeammate(new CreateTeammateRequest(name));
    }

    @ApiOperation(value = "createTeam", notes = "Create a new teamm with a name given in parameter")
    @PostMapping( {"/teams/"})
    public CreateTeamResponse createTeam(@Valid @RequestBody String name) {
        return applicationService.createTeam(new CreateTeamRequest(name));
    }

    @ApiOperation(value = "addTeammateToTeam", notes = "Create a membership relation between a team and a teammate")
    @PostMapping( {"/teams/{teamId}/teammates/{teammateId}"})
    public AddTeammateToTeamResponse addTeammateToTeam(@PathVariable(value = "teamId") Long teamId, @PathVariable(value = "teammateId") Long teammateId) {
        return applicationService.addTeammateToTeam(new AddTeammateToTeamRequest(teammateId, teamId));
    }


}
