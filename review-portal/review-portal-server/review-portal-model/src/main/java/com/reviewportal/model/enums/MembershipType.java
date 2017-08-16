package com.reviewportal.model.enums;

/**
 * @author imfroz
 *
 */
public enum MembershipType {

    PROFESSIONAL("PROFESSIONAL", "Professional"), REVIEW_WRITER("REVIEW_WRITER", "Review Writer");

    private String value;
    private String label;

    private MembershipType(String pValue, String pLabel) {
        value = pValue;
        label = pLabel;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

}
