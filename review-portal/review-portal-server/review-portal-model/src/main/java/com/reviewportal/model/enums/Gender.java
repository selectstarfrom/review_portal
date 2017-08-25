package com.reviewportal.model.enums;

/**
 * @author imfroz
 *
 */
public enum Gender {
    MALE("MALE", "Male"), FEMALE("FEMALE", "Female");

    private String value;
    private String label;

    private Gender(String pValue, String pLabel) {
        value = pValue;
        label = pLabel;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    boolean equals(String pValue) {
        return getValue().equals(pValue);
    }

}
