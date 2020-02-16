package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.TeamEntity;

import java.io.Serializable;
import java.util.List;


public class GetAllTeamsResponse implements Serializable {

    private List<TeamEntity> teams;

    public GetAllTeamsResponse(List<TeamEntity> teams) {
        this.teams = teams;
    }

    public List<TeamEntity> getTeams() {
        return teams;
    }

    private void setTeams(List<TeamEntity> teams) {
        this.teams = teams;
    }
}
