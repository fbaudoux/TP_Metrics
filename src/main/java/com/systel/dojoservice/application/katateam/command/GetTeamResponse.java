package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.TeamEntity;
import com.systel.dojoservice.domain.kata.entity.TeammateEntity;

import java.util.List;

public class GetTeamResponse {

    private TeamEntity aTeam;
    private List<TeammateEntity> members;

    public GetTeamResponse(TeamEntity aTeam, List<TeammateEntity> members) {
        this.aTeam = aTeam;
        this.members = members;
    }

    public TeamEntity getaTeam() {
        return aTeam;
    }

    private void setaTeam(TeamEntity aTeam) {
        this.aTeam = aTeam;
    }

    public List<TeammateEntity> getMembers() {
        return members;
    }
}
