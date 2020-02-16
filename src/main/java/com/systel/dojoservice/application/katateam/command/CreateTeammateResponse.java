package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.TeammateEntity;

public class CreateTeammateResponse {

    private final TeammateEntity createdTeammate;

    public CreateTeammateResponse(TeammateEntity teammate) {
        this.createdTeammate = teammate;
    }

    public TeammateEntity getCreatedTeammate() {
        return createdTeammate;
    }
}
