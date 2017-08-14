package com.reviewportal.webclient.web.managedbeans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public abstract class AbstractMBean implements Serializable {

	private static final long serialVersionUID = 8824642391700640480L;

	protected String getLoggedInUsername() {
		return "syed_firoze";
	}

	protected String getLoggedInUserFullName() {
		return "Syed Firoze";
	}

	protected AbstractMBean getViewScoppedBean(String pViewScopedBean) {
		Map<String, Object> viewMap = getContext().getViewRoot().getViewMap();
		Object lObject = viewMap.get(pViewScopedBean);
		if (lObject != null) {
			AbstractMBean viewScopedBean = (AbstractMBean) lObject;
			return viewScopedBean;
		} else {
			// throw exception
			return null;
		}
	}

	protected IPropertyAccessor getPropertyAccessorBean(String pViewScopedBean) {
		String lExpression = "#{" + pViewScopedBean + "}";
		return getApplication().evaluateExpressionGet(getContext(), lExpression, IPropertyAccessor.class);
	}

	protected AbstractActionBean getActionBean(String pViewScopedBean) {
		String lExpression = "#{" + pViewScopedBean + "}";
		return getApplication().evaluateExpressionGet(getContext(), lExpression, AbstractActionBean.class);
	}

	private Application getApplication() {
		return getContext().getApplication();
	}

	private FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

}