package com.mage.jenkins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Queue extends BaseModel {
    @JsonProperty("_class")
    private String cls;

    private List<Object> discoverableItems;

    private List<BlockedItem> items;


    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public List<Object> getDiscoverableItems() {
        return discoverableItems;
    }

    public void setDiscoverableItems(List<Object> discoverableItems) {
        this.discoverableItems = discoverableItems;
    }

    public List<BlockedItem> getItems() {
        return items;
    }

    public void setItems(List<BlockedItem> items) {
        this.items = items;
    }
}
