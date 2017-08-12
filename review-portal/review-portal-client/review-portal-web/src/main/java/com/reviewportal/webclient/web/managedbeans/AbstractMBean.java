package com.reviewportal.webclient.web.managedbeans;

import java.io.Serializable;

public abstract class AbstractMBean implements Serializable {

    private static final long serialVersionUID = 8824642391700640480L;

    protected String getLoggedInUsername() {
        return "syed_firoze";
    }

    protected String getLoggedInUserFullName() {
        return "Syed Firoze";
    }
}