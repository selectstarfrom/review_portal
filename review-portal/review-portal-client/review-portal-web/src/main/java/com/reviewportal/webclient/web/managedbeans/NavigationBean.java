package com.reviewportal.webclient.web.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NavigationBean {

	public String goSearchProfessionals() {
		return "/searchProfessionals";
	}
}
