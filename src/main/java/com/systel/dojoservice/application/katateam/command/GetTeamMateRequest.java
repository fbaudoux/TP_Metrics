package com.systel.dojoservice.application.katateam.command;

public class GetTeamMateRequest {

    private final String teammateId;

    public GetTeamMateRequest(String teammateId) {

        this.teammateId = teammateId;
    }

    public String getTeammateId() {
        return teammateId;
    }
}
