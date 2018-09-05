package com.mage.jenkins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crumb extends BaseModel {
    @JsonProperty("_class")
    private String cls;

    private String crumb;

    private String crumbRequestField;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCrumb() {
        return crumb;
    }

    public void setCrumb(String crumb) {
        this.crumb = crumb;
    }

    public String getCrumbRequestField() {
        return crumbRequestField;
    }

    public void setCrumbRequestField(String crumbRequestField) {
        this.crumbRequestField = crumbRequestField;
    }
}
