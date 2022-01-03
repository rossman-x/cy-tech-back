package com.cytech.cytechback.subject;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.ue.UE;


public class SubjectDTO implements SimpleDto {

    private String name;
    private UE ue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }
}
