package com.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Designations.class)
@interface Designation {
	String value() default "Java";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Designations {

	Designation[] value();
}

@Designation(value = "Employee")
@Designation(value = "Agent")
class Person {

}

public class RepeatingAnnotationDemo {

}
