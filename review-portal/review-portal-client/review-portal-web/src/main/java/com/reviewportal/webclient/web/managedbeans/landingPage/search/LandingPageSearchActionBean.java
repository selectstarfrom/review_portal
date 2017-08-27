package com.reviewportal.webclient.web.managedbeans.landingPage.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.LoggerFactory;

import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "landingPageSearchActionBean")
@ViewScoped
public class LandingPageSearchActionBean extends AbstractActionBean {

	private static final long serialVersionUID = -3657805465063380731L;

	public LandingPageSearchActionBean() {
		super();
		logger = LoggerFactory.getLogger(LandingPageSearchActionBean.class);
	}

	private LandingPageSearchAccessor getAccessor() {
		return getParent().getAccessor();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LandingPageViewBean getParent() {
		return super.getParent();
	}

}
