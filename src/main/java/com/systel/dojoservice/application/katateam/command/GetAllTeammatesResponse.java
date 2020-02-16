package com.systel.dojoservice.application.katateam.command;

import com.systel.dojoservice.domain.kata.entity.TeammateEntity;

import java.util.List;

public class GetAllTeammatesResponse {

    private final List<TeammateEntity> teammateList;

    public GetAllTeammatesResponse(List<TeammateEntity> teammateList) {
        this.teammateList = teammateList;
    }

    public List<TeammateEntity> getTeammateList() {
        return teammateList;
    }
}
