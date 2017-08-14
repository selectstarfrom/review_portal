package com.reviewportal.webclient.web.managedbeans;

public abstract class AbstractViewBean extends AbstractMBean {

	private static final long serialVersionUID = -7200539642566386438L;
	protected IPropertyAccessor accessor;
	protected AbstractActionBean actions;

	public abstract IPropertyAccessor getAccessor();

	public abstract AbstractActionBean getActions();

	public void setAccessor(IPropertyAccessor accessor) {
		this.accessor = accessor;
	}

	public void setActions(AbstractActionBean actions) {
		this.actions = actions;
	}

}