package com.reviewportal.webclient.web.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PropertyAccessor {

	public Class<? extends IPropertyAccessor> className();

}