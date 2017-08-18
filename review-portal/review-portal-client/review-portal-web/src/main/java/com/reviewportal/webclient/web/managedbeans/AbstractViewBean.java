package com.reviewportal.webclient.web.managedbeans;

import javax.faces.bean.ManagedBean;

import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;

public abstract class AbstractViewBean extends AbstractMBean {

	private static final long serialVersionUID = -7200539642566386438L;
	protected IPropertyAccessor accessor;
	protected AbstractActionBean actions;

	public void init() {

		PropertyAccessor lPropertyAccessorAnnotation = this.getClass().getAnnotation(PropertyAccessor.class);
		Class<? extends IPropertyAccessor> lPropertyAccessorClassName = lPropertyAccessorAnnotation.className();
		ManagedBean lPropertyAccessorBeanAnnotation = lPropertyAccessorClassName.getAnnotation(ManagedBean.class);
		String lPropertyAccessorBeanName = lPropertyAccessorBeanAnnotation.name();
		this.accessor = getPropertyAccessorBean(lPropertyAccessorBeanName);

		ViewAction lViewActionAnnotation = this.getClass().getAnnotation(ViewAction.class);
		Class<? extends AbstractActionBean> llViewActionClass = lViewActionAnnotation.className();
		ManagedBean lViewActionBeanAnnotation = llViewActionClass.getAnnotation(ManagedBean.class);
		String lViewActionBeanName = lViewActionBeanAnnotation.name();
		this.actions = getActionBean(lViewActionBeanName);

		getActions().setParent(this);
	}

	public abstract IPropertyAccessor getAccessor();

	public abstract AbstractActionBean getActions();

	public void setAccessor(IPropertyAccessor accessor) {
		this.accessor = accessor;
	}

	public void setActions(AbstractActionBean actions) {
		this.actions = actions;
	}

}