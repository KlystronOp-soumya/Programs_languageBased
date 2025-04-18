import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = loadClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		}
		return defineClass(name, classData, 0, classData.length);
	}

	private byte[] loadClassData(String name) {
		try {
			String fileName = name.replace('.', File.separatorChar) + ".class";
			InputStream inputStream = new FileInputStream(fileName);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			int nextValue = 0;
			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
			return byteStream.toByteArray();
		} catch (IOException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			CustomClassLoader loader = new CustomClassLoader();
			Class<?> clazz = loader.loadClass("com.example.MyClass");
			System.out.println(clazz.getPackageName());
			Object instance = clazz.newInstance();
			System.out.println("Class loaded and instance created: " + instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
