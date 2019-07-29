package com.example.bprlab.project.Model;

public class TECHPORTModel {
    String title;
    String status;
    String startDate;
    String endDate;

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public TECHPORTModel(String title, String status, String startDate, String endDate) {
        this.title = title;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
