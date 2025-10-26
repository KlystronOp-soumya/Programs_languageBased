package com.demo.annot.miniproj.DI;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.demo.annot.miniproj.DI.annotation.Autowired;
import com.demo.annot.miniproj.DI.annotation.Component;
import com.demo.annot.miniproj.DI.annotation.ComponentScan;
import com.demo.annot.miniproj.DI.annotation.Configuration;

public class ApplicationContext {

	private static Map<Class<?>, Object> contextClassesMap = new HashMap<>();

	/*
	 * Takes the configuration class
	 */
	public ApplicationContext(Class<AppConfig> clazz) {
		MicroKeights.initializeContext(clazz);
	}

	private static class MicroKeights {

		private static void initializeContext(Class<?> clazz) {

			if (clazz.isAnnotationPresent(Configuration.class)) {
				throw new RuntimeException(clazz.getName() + " is not a configuration class");
			} else {
				ComponentScan componentScan = clazz.getAnnotation(ComponentScan.class);
				String pkgName = componentScan.packageName();

				String packageStructure = "bin/" + pkgName.replace(".", "/");

				File[] files = findClazzs(new File(packageStructure));

				for (File file : files) {
					String name = pkgName + "." + file.getName().replace(".class", "");
					try {
						Class<?> loadingClazz = Class.forName(name);

						if (loadingClazz.isAnnotationPresent(Component.class)) {

							Constructor<?> constructor = loadingClazz.getConstructor();

							Object newInstance = constructor.newInstance();
							contextClassesMap.put(loadingClazz, newInstance);

						}
					} catch (Exception e) {
						throw new RuntimeException("Cannot load component\n " + e.getMessage());
					}
				}

			}

		}

		private static File[] findClazzs(File file) {
			if (!file.exists()) {
				throw new FileSystemNotFoundException("Package " + file + " does not exist");

			} else {
				File[] clazzs = file.listFiles(e -> e.getName().endsWith(".class"));
				return clazzs;
			}

		}
	}

	public <T> T getBean(Class<T> beanz) {
		try {

			T object = (T) this.contextClassesMap.get(beanz);

			Field[] declaredFields = beanz.getDeclaredFields();

			injectBean(object, declaredFields);

			return object;

		} catch (Exception e) {
			throw new RuntimeException("Could not get the bean " + e.getMessage());
		}
	}

	private <T> void injectBean(T object, Field[] declaredFields) {

		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Autowired.class)) {
				field.setAccessible(true);
				Class<?> typeOfInner = field.getType();
				Object innerDependency = this.contextClassesMap.get(typeOfInner);
				try {
					field.set(object, innerDependency);
					// now if dependecy has some other dependency
					Field[] innerDepFields = typeOfInner.getDeclaredFields();
					// recursive call
					injectBean(innerDependency, innerDepFields);

				} catch (IllegalArgumentException | IllegalAccessException e) {

					e.printStackTrace();
				}

			}
		}

	}
}
