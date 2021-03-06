package com.reviewportal.webclient.web.managedbeans;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author imfroz
 *
 */
public abstract class AbstractBaseBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 12321L;

    @ManagedProperty("#{msg}")
    private ResourceBundle bundle;

    protected Logger logger = null;

    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    protected String getLoggedInUsername() {
        return "syed_firoze";
    }

    protected String getLoggedInUserFullName() {
        return "Syed Firoze";
    }

    protected AbstractBaseBean getViewScoppedBean(String pViewScopedBean) {
        Map<String, Object> viewMap = getContext().getViewRoot().getViewMap();
        Object lObject = viewMap.get(pViewScopedBean);
        if (lObject != null) {
            AbstractBaseBean viewScopedBean = (AbstractBaseBean) lObject;
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

    protected void info(String pMessage, String pClientId) {
        message(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", pMessage), pClientId);
    }

    protected void error(String pMessage, String pClientId) {
        message(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", pMessage), pClientId);
    }

    private void message(FacesMessage pMessage, String pClientId) {
        getContext().addMessage(pClientId, pMessage);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
    public String getMessage(String pName) {
        return getBundle().getString(pName);
    }

    public void setBundle(ResourceBundle pBundle) {
        bundle = pBundle;
    }

}