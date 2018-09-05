package com.mage.jenkins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job extends BaseModel {
    @JsonProperty("_class")
    private String cls;

    private String name;

    private String url;

    private String color;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
