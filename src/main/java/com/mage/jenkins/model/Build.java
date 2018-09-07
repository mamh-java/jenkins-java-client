package com.mage.jenkins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Build extends BaseModel {
    @JsonProperty("_class")
    private String cls;

    private int number;

    private String url;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
