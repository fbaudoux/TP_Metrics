package com.systel.dojoservice.application.katateam.command;

public class GetTeamRequest {

    private final Long teamId;

    public GetTeamRequest(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

}
