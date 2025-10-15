package com.demo.annot.miniproj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class Hibernate<T> {

	private String table;
	private Set<String> columns;

	public void save(List<T> entities) {

	}

	public void save(T entity) throws Exception {
		Class<T> clazz = (Class<T>) entity.getClass();
		// get the table name
		Annotation annotation;
		if (clazz.isAnnotationPresent(ToTable.class)) {
			annotation = clazz.getAnnotation(ToTable.class);
			this.table = ((ToTable) annotation).name();
		}
		/*
		 * Annotation[] classAnnotations = clazz.getAnnotations(); for (Annotation
		 * annotation : classAnnotations) { if
		 * (annotation.annotationType().getSimpleName().equals("ToTable")) { ToTable
		 * toTable = (ToTable) annotation; this.table = toTable.name(); } }
		 */

		// get the columns
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field eachField : fields) {
			if (eachField.isAnnotationPresent(PrimaryKey.class)) {
				PrimaryKey primaryKey = eachField.getAnnotation(PrimaryKey.class);
				System.out.println(primaryKey.name() + ": " + primaryKey.autoIncrement());
			} else if (eachField.isAnnotationPresent(Column.class)) {
				Column columnAnnotation = eachField.getAnnotation(Column.class);
				if (columnAnnotation.name().isBlank()) {
					System.out.println(eachField.getName().toUpperCase());
				} else {
					System.out.println(columnAnnotation.name());
				}
			}
		}
	}

}
