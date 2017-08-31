package com.reviewportal.webapp.core;

public class SelectItem {

    private String value;
    private String label;
    private String description;

    public SelectItem(String pValue, String pLabel) {
        super();
        value = pValue;
        label = pLabel;
        description = "";
    }

    public SelectItem(String pValue, String pLabel, String pDescription) {
        super();
        value = pValue;
        label = pLabel;
        description = pDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String pValue) {
        value = pValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String pLabel) {
        label = pLabel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        description = pDescription;
    }

}
