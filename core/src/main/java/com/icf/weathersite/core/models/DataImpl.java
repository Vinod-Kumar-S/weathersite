package com.icf.weathersite.core.models;

import com.icf.weathersite.core.models.Data;

import javax.inject.Inject;

public class DataImpl implements Data {

    @Inject
    String fname;

    @Inject
    String lname;

    @Inject
    Boolean professor;


    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public Boolean getIsProfessor() {
        return professor;
    }
}
