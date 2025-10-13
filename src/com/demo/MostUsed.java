package com.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE }) // to be applied on method and class
@Retention(RetentionPolicy.RUNTIME) // will have effect during RunTime
public @interface MostUsed {

	String value() default "Java";

}
