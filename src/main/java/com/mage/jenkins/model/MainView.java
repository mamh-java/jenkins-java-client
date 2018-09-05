package com.mage.jenkins.model;

import java.util.List;

public class MainView extends View {
    private String description;
    private List<Job> jobs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
