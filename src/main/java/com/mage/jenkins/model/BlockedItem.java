package com.mage.jenkins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockedItem extends BaseModel {
    @JsonProperty("_class")
    private String cls;

    private Job task;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Job getTask() {
        return task;
    }

    public void setTask(Job task) {
        this.task = task;
    }
}
