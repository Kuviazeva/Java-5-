package di;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private final Properties properties;

    public Injector() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Не найден application.properties", e);
        }
    }

    public <T> T inject(T object) {
        Class<?> cls = object.getClass();

        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {

                String interfaceName = field.getType().getName();
                String implClassName = properties.getProperty(interfaceName);

                if (implClassName == null) {
                    throw new RuntimeException("Не найдена реализация для " + interfaceName);
                }

                try {
                    Class<?> implClass = Class.forName(implClassName);
                    Object implInstance = implClass.getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(object, implInstance);

                } catch (Exception e) {
                    throw new RuntimeException("Ошибка внедрения зависимости", e);
                }
            }
        }
        return object;
    }
}