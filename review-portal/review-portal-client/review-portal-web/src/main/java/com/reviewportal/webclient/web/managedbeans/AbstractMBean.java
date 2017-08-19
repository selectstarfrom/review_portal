package com.reviewportal.webclient.web.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import com.reviewportal.service.dto.UserDTO;

/**
 * @author imfroz
 *
 */
public abstract class AbstractMBean extends AbstractBaseBean implements Serializable {

    private static final long serialVersionUID = -544212872529325792L;

    @ManagedProperty("#{appCache}")
    private ApplicationCacheMBean appCacheBean;

    @ManagedProperty("#{sessionCache}")
    private SessionCacheMBean sessionCache;

    public UserDTO getLoggedInUser() {
        return sessionCache.getLoggedInUser();
    }

    public ApplicationCacheMBean getAppCacheBean() {
        return appCacheBean;
    }

    public void setAppCacheBean(ApplicationCacheMBean pAppCacheBean) {
        appCacheBean = pAppCacheBean;
    }

    public SessionCacheMBean getSessionCache() {
        return sessionCache;
    }

    public void setSessionCache(SessionCacheMBean pSessionCache) {
        sessionCache = pSessionCache;
    }

}