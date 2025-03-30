package com.starship.microservice.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionMapper {
    private static final Logger log = LoggerFactory.getLogger(ReflectionMapper.class);

    public static <T> T map(Object source, Class<T> targetClass) {
        try {
            T targetObject = targetClass.getDeclaredConstructor().newInstance();
            Field[] fields = targetClass.getDeclaredFields();

            for (Field targetField : fields) {
                targetField.setAccessible(true);
                Field sourceField = source.getClass().getDeclaredField(targetField.getName());
                sourceField.setAccessible(true);

                if (sourceField.get(source) != null) {
                    targetField.set(targetObject, sourceField.get(source));
                }
            }
            return targetObject;
        } catch (Exception e) {
            log.error("Error mapper reflection mapper {}", e.getMessage(), e);
        }
        return null;
    }
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(entity -> ReflectionMapper.map(entity, targetClass))
                .toList();
    }
}
