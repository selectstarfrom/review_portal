package com.reviewportal.webclient.web.managedbeans;

public abstract class AbstractActionBean {

	protected AbstractViewBean parent;

	@SuppressWarnings("unchecked")
	public <T extends AbstractViewBean> T getParent() {
		return (T) parent;
	}

	public void setParent(AbstractViewBean parent) {
		this.parent = parent;
	}
}
