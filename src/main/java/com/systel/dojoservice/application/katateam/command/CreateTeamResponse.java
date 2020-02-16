package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.TeamEntity;

public class CreateTeamResponse {

    private final TeamEntity createdTeam;


    public CreateTeamResponse(TeamEntity createdTeam) {
        this.createdTeam = createdTeam;
    }

    public TeamEntity getCreatedTeam() {
        return createdTeam;
    }


}
