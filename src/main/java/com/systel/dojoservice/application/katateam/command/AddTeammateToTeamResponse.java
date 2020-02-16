package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.Membership;

public class AddTeammateToTeamResponse {

    private final Membership membership;

    public AddTeammateToTeamResponse(Membership membership) {
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }
}
