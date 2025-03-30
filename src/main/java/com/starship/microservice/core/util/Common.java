package com.starship.microservice.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

public class Common {
    private static final Logger log = LoggerFactory.getLogger(Common.class);

    public static <T> T setFieldsToNull(T obj, String... fieldNames) {
        if (obj == null || fieldNames == null) {
            throw new IllegalArgumentException("Object and field names cannot be null");
        }

        Class<?> clazz = obj.getClass();

        for (String fieldName : fieldNames) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.getType().isPrimitive()) {
                    throw new IllegalArgumentException("Cannot set primitive field to null: " + fieldName);
                }

                field.set(obj, null);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.error("Error setting field {} to null: {}", fieldName, e.getMessage(), e);
            }
        }
        return obj;
    }

    public static <T> List<T> setFieldsToNull(List<T> list, String... fieldNames) {
        if (list == null || fieldNames == null) {
            throw new IllegalArgumentException("List and field names cannot be null");
        }

        for (T obj : list) {
            if (obj != null) {
                Class<?> clazz = obj.getClass();

                for (String fieldName : fieldNames) {
                    try {
                        Field field = getField(clazz, fieldName);
                        if (field != null) {
                            field.setAccessible(true);

                            if (field.getType().isPrimitive()) {
                                throw new IllegalArgumentException("Cannot set primitive field to null: " + fieldName);
                            }

                            field.set(obj, null);
                        } else {
                            log.warn("Field '{}' not found in class '{}'", fieldName, clazz.getName());
                        }

                    } catch (IllegalAccessException e) {
                        log.error("Error setting field {} to null: {}", fieldName, e.getMessage(), e);
                    }
                }
            }
        }
        return list;
    }

    private static Field getField(Class<?> clazz, String fieldName) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    public static String generateRandomVerifyCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
