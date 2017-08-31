package com.reviewportal.model.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  
public  @interface IAppLauncher{  
int value1();  
String value2();  
}  