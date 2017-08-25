package com.reviewportal.webclient.web.managedbeans;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.impl.services.UserServicesImpl;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "appUtil")
@ApplicationScoped
public class ApplicationUtilMBean extends AbstractBaseBean {

    private static final long serialVersionUID = 5278713551702595165L;

    @Autowired
    protected transient UserServicesImpl userServices;

    @PostConstruct
    public void init() {
        super.init();
    }

    public StreamedContent getProfileImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            String lUserId = context.getExternalContext().getRequestParameterMap().get("id");
            if (lUserId != null && !lUserId.isEmpty()) {
                byte[] lBytes = userServices.getDisplayPicture(Long.valueOf(lUserId));
                return new DefaultStreamedContent(new ByteArrayInputStream(lBytes));
            }
            byte[] lBytes = userServices.getDisplayPicture(-1L);
            return new DefaultStreamedContent(new ByteArrayInputStream(lBytes));
        }
    }

    public long getDate() {
        return System.currentTimeMillis();
    }
}