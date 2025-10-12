package com.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

class BaseEntity {
	private int id;
	private String uniqueKey;

	public BaseEntity() {
		this.id = Integer.parseInt(UUID.randomUUID().toString());
		this.uniqueKey = "000";
	}

	public BaseEntity(final int id, final String uniqueKey) {
		this.id = id;
		this.uniqueKey = uniqueKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

}

class Entity extends BaseEntity {

	public String type;
	private String domain;
	public transient double index;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Entity(String type, String domain, double index) {
		super();
		this.type = type;
		this.domain = domain;
		this.index = index;
	}

	public Entity(int id, String key, String type, String domain, double index) {
		super(id, key);
		this.type = type;
		this.domain = domain;
		this.index = index;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Entity [type=" + type + ", domain=" + domain + ", index=" + index + "]";
	}

}

@FunctionalInterface
interface Base {
	void apply(final String str);
}

class BaseImpl implements Base {

	@Override
	public void apply(final String str) {
		System.out.println(str);

	}

}

class Foo {

	private Foo() { // Made the constructor private
		System.out.println("Foo class Object was created");
	}
}

class MyClass extends BaseImpl {

	public MyClass() {
		System.out.println("Myclass object was created");
	}
}

public class UdemyReflectionDemo {

	public static void main(String[] args) {
		// If you use reflection then nothing is truly private
		try {
			Class<?> clazz = Class.forName("com.demo.Foo");
			Constructor<?> cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);

			Object fooObject = cons.newInstance();

			// different waays of creating class objects
			// 1. forName

			Class<?> clz1 = Class.forName("java.lang.String");
			Class<?> clz2 = Class.forName("java.lang.String");

			// both the objects points to same address
			System.out.println(clz1 == clz2);

			// 2. .class
			Class<?> clz3 = Integer.class;
			Class<?> clz4 = String.class;

			// 3. object.getClass
			MyClass oClass = new MyClass();
			Class<? extends MyClass> myClazz = oClass.getClass();

			// get the super class
			Class<?> superclass = myClazz.getSuperclass();
			Method[] methods = superclass.getMethods();
			for (Method method : methods) {
				System.out.println("Mehtod name: " + method.getName());
				System.out.println("Modifier: " + method.getModifiers());
				if (method.getName().equals("apply")) {
					method.invoke(oClass, "Hello World");
				}
			}
			System.out.println("Class name:" + myClazz.getName());
			System.out.println("Canonical name:" + myClazz.getCanonicalName());
			System.out.println("Super class name:" + myClazz.getSuperclass().getSimpleName());
			// get all the interfaces
			Class<?>[] interfaces = myClazz.getInterfaces();

			// Arrays.stream(interfaces).forEach(System.out::println);

			fieldInfo();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fieldInfo()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Entity entity = new Entity("Object", "demo", 1.0);
		System.out.println(entity);

		// get the class
		Class<? extends BaseEntity> clazz = entity.getClass();
		// non-declared elements: all the public elements in the class and its super
		// class
		// declared elements: all the elements in the class
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println(field.getName()); // shows the public fields
		}

		Field[] decFields = clazz.getDeclaredFields();
		for (Field field : decFields) {
			System.out.println(field.getName()); // shows all the fields in Entity class including the private
		}

		Field type = clazz.getField("type");
		Field domain = clazz.getDeclaredField("domain");
		type.set(entity, "POJO");
		domain.setAccessible(true); // do this otherwise get exception
		domain.set(entity, "Enetrprise");
		System.out.println(entity);

	}

	private static void methodInfo() {

	}

}
