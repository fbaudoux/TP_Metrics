package com.systel.dojoservice.application.katateam.command;

public class CreateTeamRequest {

    private final String name;

    public CreateTeamRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
