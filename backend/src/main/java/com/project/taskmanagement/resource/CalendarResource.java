package com.project.taskmanagement.resource;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CalendarResource {

    private String title;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm")
    private LocalDate start;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm")
    private LocalDate end;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
