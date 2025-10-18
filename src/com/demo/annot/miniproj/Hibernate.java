package com.demo.annot.miniproj;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hibernate<T> {

	private String table;
	private Set<String> columns;

	public void save(List<T> entities) {

	}

	public void save(T entity) throws Exception {
		Class<T> clazz = (Class<T>) entity.getClass();
		// get the table name
		ToTable annotation;
		if (clazz.isAnnotationPresent(ToTable.class)) {
			annotation = clazz.getAnnotation(ToTable.class);
			this.table = annotation.name().isBlank() ? clazz.getName() : annotation.name();
			System.out.println("Provided table name: " + this.table);
		}
		/*
		 * Annotation[] classAnnotations = clazz.getAnnotations(); for (Annotation
		 * annotation : classAnnotations) { if
		 * (annotation.annotationType().getSimpleName().equals("ToTable")) { ToTable
		 * toTable = (ToTable) annotation; this.table = toTable.name(); } }
		 */

		// get the columns
		HashMap<Field, Class<?>> columnNameTypeMap = new HashMap<>();

		Field[] fields = entity.getClass().getDeclaredFields();

		for (Field eachField : fields) {

			if (eachField.isAnnotationPresent(PrimaryKey.class)) {
				PrimaryKey primaryKey = eachField.getAnnotation(PrimaryKey.class);

				System.out.println(primaryKey.name() + ": " + primaryKey.autoIncrement());
				columnNameTypeMap.put(eachField, eachField.getType());
			} else if (eachField.isAnnotationPresent(Column.class)) {

				Column columnAnnotation = eachField.getAnnotation(Column.class);

				if (columnAnnotation.name().isBlank()) {
					System.out.println(eachField.getName().toUpperCase());
				} else {
					System.out.println(columnAnnotation.name());
				}
				columnNameTypeMap.put(eachField, eachField.getType());
			}

		}

		// to get the values generate a string of place holders
		String insertSql = "INSERT INTO :tableName(:columns) VALUES(:values)".replaceAll(":tableName", this.table);

		String columnNames = columnNameTypeMap.entrySet().stream().map(e -> e.getKey().getName())
				.collect(Collectors.joining(","));
		long nuOfCols = columnNameTypeMap.entrySet().stream().count();

		String colValPlaceHolders = IntStream.range(0, (int) nuOfCols).mapToObj(e -> "?")
				.collect(Collectors.joining(","));

		System.out.println("Placeholders: " + colValPlaceHolders);
		insertSql = insertSql.replaceAll(":columns", columnNames).replaceAll(":values", colValPlaceHolders);
		System.out.println(insertSql);

	}

}
