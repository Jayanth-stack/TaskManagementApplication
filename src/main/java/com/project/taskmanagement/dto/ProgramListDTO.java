package com.project.taskmanagement.dto;

import com.project.taskmanagement.entity.Program;

import java.util.List;

public class ProgramListDTO {

    private List<Program> programList;

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }
}
