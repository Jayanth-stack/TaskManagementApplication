package com.project.taskmanagement.resource;

import java.util.List;

public class ProgramListResource {

    private List<ProgramResource> programList;

    public List<ProgramResource> getProgramList(){
        return programList;
    }
    public void setProgramList(List<ProgramResource> programList){
        this.programList = programList;
    }
}
