package com.reviewportal.webclient.web.managedbeans;

public abstract class AbstractActionBean extends AbstractMBean {

    private static final long serialVersionUID = 1564225107131672288L;

    protected AbstractViewBean parent;

    @SuppressWarnings("unchecked")
    public <T extends AbstractViewBean> T getParent() {
        return (T) parent;
    }

    public void setParent(AbstractViewBean parent) {
        this.parent = parent;
    }
}
