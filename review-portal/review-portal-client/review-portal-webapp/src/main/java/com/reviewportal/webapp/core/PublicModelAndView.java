package com.reviewportal.webapp.core;

import org.springframework.web.servlet.ModelAndView;

public class PublicModelAndView extends ModelAndView {

    public void init() {

        setViewName("index");
        ImageGenerator lApplicationUtilMBean = new ImageGenerator();
        super.addObject("imageGen", lApplicationUtilMBean);

    }

}